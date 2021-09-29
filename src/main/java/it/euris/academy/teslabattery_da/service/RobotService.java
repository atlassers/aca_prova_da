package it.euris.academy.teslabattery_da.service;

import java.util.List;
import it.euris.academy.teslabattery_da.data.dto.RobotDto;

public interface RobotService {

public List<RobotDto> getAll();
  
  public RobotDto get(Long id);
  
  public RobotDto add(RobotDto dto);
  
  public RobotDto update(RobotDto dto);
  
  public Boolean delete(Long id);
}
