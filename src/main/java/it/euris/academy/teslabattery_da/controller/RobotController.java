package it.euris.academy.teslabattery_da.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.euris.academy.teslabattery_da.data.dto.RobotDto;
import it.euris.academy.teslabattery_da.service.RobotService;

@RestController
@RequestMapping("/robots")
public class RobotController {

  @Autowired
  RobotService robotService;
  
  @GetMapping("/v1")
  public List<RobotDto> getAll() {
    return robotService.getAll();
  }
  
  @GetMapping("/v1/{id}")
  public RobotDto getById(@PathVariable("id") Long id) {
    return robotService.get(id);
  }
  
  @DeleteMapping("/v1/{id}")
  public Boolean delete(@PathVariable("id") Long id) {
    return robotService.delete(id);
  }
  
  @PostMapping("/v1")
  public RobotDto insert(@RequestBody RobotDto dto) {
    return robotService.add(dto);
  }
  
  @PutMapping("/v1")
  public RobotDto update(@RequestBody RobotDto dto) {
    return robotService.update(dto);
  }
  
  @PatchMapping("/v1")
  public RobotDto patch(@RequestBody RobotDto dto) {
    return robotService.update(dto);
  }
}
