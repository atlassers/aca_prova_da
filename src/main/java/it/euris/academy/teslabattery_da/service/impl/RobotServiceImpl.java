package it.euris.academy.teslabattery_da.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.euris.academy.teslabattery_da.data.dto.RobotDto;
import it.euris.academy.teslabattery_da.data.model.Robot;
import it.euris.academy.teslabattery_da.exception.IdMustBeNullException;
import it.euris.academy.teslabattery_da.exception.IdMustNotBeNullException;
import it.euris.academy.teslabattery_da.repository.RobotRepository;
import it.euris.academy.teslabattery_da.service.RobotService;

@Service
public class RobotServiceImpl implements RobotService {

  @Autowired
  RobotRepository robotRepository;
  
  @Override
  public List<RobotDto> getAll() {
    return robotRepository.findAll()
        .stream().map(Robot::toDto)
        .collect(Collectors.toList());
  }

  @Override
  public RobotDto get(Long id) {
    Optional<Robot> robot = robotRepository.findById(id);
    
    if(robot.isPresent()) {
      return robot.get().toDto();
    }
    return null;
  }

  @Override
  public RobotDto add(RobotDto dto) {
    if(dto.getId() != null) {
      throw new IdMustBeNullException();
    }
    return robotRepository.save(dto.toModel()).toDto();
  }

  @Override
  public RobotDto update(RobotDto dto) {
    if(dto.getId() == null) {
      throw new IdMustNotBeNullException();
    }
    return robotRepository.save(dto.toModel()).toDto();
  }

  @Override
  public Boolean delete(Long id) {
    robotRepository.deleteById(id);
    
    return robotRepository.findById(id).isEmpty();
  }

}
