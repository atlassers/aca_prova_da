package it.euris.academy.teslabattery_da.data.dto;

import java.util.List;
import java.util.stream.Collectors;
import com.fasterxml.jackson.annotation.JsonIgnore;
import it.euris.academy.teslabattery_da.data.archetype.Dto;
import it.euris.academy.teslabattery_da.data.model.Robot;
import it.euris.academy.teslabattery_da.utils.UT;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RobotDto implements Dto {

  private String id;

  private String task; 
  
  @JsonIgnore
  private List<AssemblyLineRobotDto> assemblyLineRobotDtos;
  
  @Override
  public Robot toModel() {
    Robot robot = Robot.builder()
        .id(UT.toLong(id))
        .task(UT.getRobotTask(task))
        .build();
    
    if(this.getAssemblyLineRobotDtos() != null) {
      robot.getAssemblyLineRobots().addAll(this.getAssemblyLineRobotDtos()
          .stream().map(AssemblyLineRobotDto::toModel).collect(Collectors.toSet()));
    }
    
    return robot;
  }

}
