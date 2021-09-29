package it.euris.academy.teslabattery_da.service;

import java.util.List;
import it.euris.academy.teslabattery_da.data.dto.FormulaDto;

public interface FormulaService {

  public List<FormulaDto> getAll();
  
  public FormulaDto get(Long id);
  
  public FormulaDto add(FormulaDto dto);
  
  public FormulaDto update(FormulaDto dto);
  
  public Boolean delete(Long id);
}
