package it.euris.academy.teslabattery_da.service;

import java.util.List;
import it.euris.academy.teslabattery_da.data.dto.ProductiveCycleDto;

public interface ProductiveCycleService {

  public List<ProductiveCycleDto> getAll();
  
  public ProductiveCycleDto get(Long id);
  
  public ProductiveCycleDto add(ProductiveCycleDto dto);
  
  public ProductiveCycleDto update(ProductiveCycleDto dto);
  
  public Boolean delete(Long id);
}
