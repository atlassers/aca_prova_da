package it.euris.academy.teslabattery_da.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.euris.academy.teslabattery_da.data.dto.ProductiveCycleDto;
import it.euris.academy.teslabattery_da.data.model.ProductiveCycle;
import it.euris.academy.teslabattery_da.exception.IdMustBeNullException;
import it.euris.academy.teslabattery_da.exception.IdMustNotBeNullException;
import it.euris.academy.teslabattery_da.repository.ProductiveCycleRepository;
import it.euris.academy.teslabattery_da.service.ProductiveCycleService;

@Service
public class ProductiveCycleServiceImpl implements ProductiveCycleService {

  @Autowired
  ProductiveCycleRepository productiveCycleRepository;
  
  @Override
  public List<ProductiveCycleDto> getAll() {
    return productiveCycleRepository.findAll()
        .stream().map(ProductiveCycle::toDto)
        .collect(Collectors.toList());
  }

  @Override
  public ProductiveCycleDto get(Long id) {
    Optional<ProductiveCycle> productiveCycle = productiveCycleRepository.findById(id);
    
    if(productiveCycle.isPresent()) {
      return productiveCycle.get().toDto();
    }
    return null;
  }

  @Override
  public ProductiveCycleDto add(ProductiveCycleDto dto) {
    if(dto.getId() != null) {
      throw new IdMustBeNullException();
    }
    return productiveCycleRepository.save(dto.toModel()).toDto();
  }

  @Override
  public ProductiveCycleDto update(ProductiveCycleDto dto) {
    if(dto.getId() == null) {
      throw new IdMustNotBeNullException();
    }
    return productiveCycleRepository.save(dto.toModel()).toDto();
  }

  @Override
  public Boolean delete(Long id) {
    productiveCycleRepository.deleteById(id);
    
    return productiveCycleRepository.findById(id).isEmpty();
  }

}
