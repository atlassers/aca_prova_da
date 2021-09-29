package it.euris.academy.teslabattery_da.service;

import java.util.List;
import it.euris.academy.teslabattery_da.data.dto.ComponentDto;

public interface ComponentService {

  public List<ComponentDto> getAll();
  
  public ComponentDto get(Long id);
  
  public ComponentDto add(ComponentDto dto);
  
  public ComponentDto update(ComponentDto dto);
  
  public Boolean delete(Long id);
}
