package it.euris.academy.teslabattery_da.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.euris.academy.teslabattery_da.data.dto.AssemblyLineDto;
import it.euris.academy.teslabattery_da.data.model.AssemblyLine;
import it.euris.academy.teslabattery_da.exception.IdMustBeNullException;
import it.euris.academy.teslabattery_da.exception.IdMustNotBeNullException;
import it.euris.academy.teslabattery_da.repository.AssemblyLineRepository;
import it.euris.academy.teslabattery_da.service.AssemblyLineService;

@Service
public class AssemblyLineServiceImpl implements AssemblyLineService {

  @Autowired
  AssemblyLineRepository assemblyLineRepository;
  
  @Override
  public List<AssemblyLineDto> getAll() {
    return assemblyLineRepository.findAll()
        .stream().map(AssemblyLine::toDto)
        .collect(Collectors.toList());
  }

  @Override
  public AssemblyLineDto get(Long id) {
    Optional<AssemblyLine> assemblyLine = assemblyLineRepository.findById(id);
    
    if(assemblyLine.isPresent()) {
      return assemblyLine.get().toDto();
    }
    return null;
  }

  @Override
  public AssemblyLineDto add(AssemblyLineDto dto) {
    if(dto.getId() != null) {
      throw new IdMustBeNullException();
    }
    
    return assemblyLineRepository.save(dto.toModel()).toDto();
  }

  @Override
  public AssemblyLineDto update(AssemblyLineDto dto) {
    if(dto.getId() == null) {
      throw new IdMustNotBeNullException();
    }
    
    return assemblyLineRepository.save(dto.toModel()).toDto();
  }

  @Override
  public Boolean delete(Long id) {
    assemblyLineRepository.deleteById(id);
    
    return assemblyLineRepository.findById(id).isEmpty();
  }

}
