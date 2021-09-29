package it.euris.academy.teslabattery_da.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.euris.academy.teslabattery_da.data.dto.ComponentDto;
import it.euris.academy.teslabattery_da.data.model.Component;
import it.euris.academy.teslabattery_da.exception.IdMustBeNullException;
import it.euris.academy.teslabattery_da.exception.IdMustNotBeNullException;
import it.euris.academy.teslabattery_da.repository.ComponentRepository;
import it.euris.academy.teslabattery_da.service.ComponentService;

@Service
public class ComponentServiceImpl implements ComponentService {

  @Autowired
  ComponentRepository componentRepository;
  
  @Override
  public List<ComponentDto> getAll() {
    return componentRepository.findAll()
        .stream().map(Component::toDto)
        .collect(Collectors.toList());
  }

  @Override
  public ComponentDto get(Long id) {
    Optional<Component> component = componentRepository.findById(id);
    
    if(component.isPresent()) {
      return component.get().toDto();
    }
    return null;
  }

  @Override
  public ComponentDto add(ComponentDto dto) {
    if(dto.getId() != null) {
      throw new IdMustBeNullException();
    }
    return componentRepository.save(dto.toModel()).toDto();
  }

  @Override
  public ComponentDto update(ComponentDto dto) {
    if(dto.getId() == null) {
      throw new IdMustNotBeNullException();
    }
    return componentRepository.save(dto.toModel()).toDto();
  }

  @Override
  public Boolean delete(Long id) {
    componentRepository.deleteById(id);
    
    return componentRepository.findById(id).isEmpty();
  }

}
