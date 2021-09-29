package it.euris.academy.teslabattery_da.service;

import java.util.List;
import it.euris.academy.teslabattery_da.data.dto.AssemblyLineDto;

public interface AssemblyLineService {

  public List<AssemblyLineDto> getAll();
  
  public AssemblyLineDto get(Long id);
  
  public AssemblyLineDto add(AssemblyLineDto dto);
  
  public AssemblyLineDto update(AssemblyLineDto dto);
  
  public Boolean delete(Long id);
}
