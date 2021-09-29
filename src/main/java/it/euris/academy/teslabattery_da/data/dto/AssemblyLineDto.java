package it.euris.academy.teslabattery_da.data.dto;

import java.util.List;
import java.util.stream.Collectors;
import com.fasterxml.jackson.annotation.JsonIgnore;
import it.euris.academy.teslabattery_da.data.archetype.Dto;
import it.euris.academy.teslabattery_da.data.model.AssemblyLine;
import it.euris.academy.teslabattery_da.utils.UT;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AssemblyLineDto implements Dto {
  
  private String id;
  
  private String name;
  
  private String completionTime;
  
  @JsonIgnore
  private List<AssemblyLineRobotDto> assemblyLineRobotDtos;
  
  @Override
  public AssemblyLine toModel() {
    AssemblyLine assemblyLine = AssemblyLine.builder()
        .id(UT.toLong(id))
        .name(name)
        .completionTime(UT.toLong(completionTime))
        .build();
    
    if(this.getAssemblyLineRobotDtos() != null) {
      assemblyLine.getAssemblyLineRobots().addAll(this.getAssemblyLineRobotDtos()
          .stream().map(AssemblyLineRobotDto::toModel).collect(Collectors.toSet()));
    }
    
    return assemblyLine;
  }

}
