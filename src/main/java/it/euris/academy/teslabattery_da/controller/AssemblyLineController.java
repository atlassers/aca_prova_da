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
import it.euris.academy.teslabattery_da.data.dto.AssemblyLineDto;
import it.euris.academy.teslabattery_da.service.AssemblyLineService;

@RestController
@RequestMapping("/assembly_lines")
public class AssemblyLineController {

  @Autowired
  AssemblyLineService assemblyLineService;
  
  @GetMapping("/v1")
  public List<AssemblyLineDto> getAll() {
    return assemblyLineService.getAll();
  }
  
  @GetMapping("/v1/{id}")
  public AssemblyLineDto getById(@PathVariable("id") Long id) {
    return assemblyLineService.get(id);
  }
  
  @DeleteMapping("/v1/{id}")
  public Boolean delete(@PathVariable("id") Long id) {
    return assemblyLineService.delete(id);
  }
  
  @PostMapping("/v1")
  public AssemblyLineDto insert(@RequestBody AssemblyLineDto dto) {
    return assemblyLineService.add(dto);
  }
  
  @PutMapping("/v1")
  public AssemblyLineDto update(@RequestBody AssemblyLineDto dto) {
    return assemblyLineService.update(dto);
  }
  
  @PatchMapping("/v1")
  public AssemblyLineDto patch(@RequestBody AssemblyLineDto dto) {
    return assemblyLineService.update(dto);
  }
}
