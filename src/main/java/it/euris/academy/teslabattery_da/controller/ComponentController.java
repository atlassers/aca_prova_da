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
import it.euris.academy.teslabattery_da.data.dto.ComponentDto;
import it.euris.academy.teslabattery_da.service.ComponentService;

@RestController
@RequestMapping("/components")
public class ComponentController {

  @Autowired
  ComponentService componentService;
  
  @GetMapping("/v1")
  public List<ComponentDto> getAll() {
    return componentService.getAll();
  }
  
  @GetMapping("/v1/{id}")
  public ComponentDto getById(@PathVariable("id") Long id) {
    return componentService.get(id);
  }
  
  @DeleteMapping("/v1/{id}")
  public Boolean delete(@PathVariable("id") Long id) {
    return componentService.delete(id);
  }
  
  @PostMapping("/v1")
  public ComponentDto insert(@RequestBody ComponentDto dto) {
    return componentService.add(dto);
  }
  
  @PutMapping("/v1")
  public ComponentDto update(@RequestBody ComponentDto dto) {
    return componentService.update(dto);
  }
  
  @PatchMapping("/v1")
  public ComponentDto patch(@RequestBody ComponentDto dto) {
    return componentService.update(dto);
  }
}
