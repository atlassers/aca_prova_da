package it.euris.academy.teslabattery_da.data.dto;

import it.euris.academy.teslabattery_da.data.archetype.Dto;
import it.euris.academy.teslabattery_da.data.archetype.Model;
import it.euris.academy.teslabattery_da.data.model.AssemblyLine;
import it.euris.academy.teslabattery_da.data.model.AssemblyLineRobot;
import it.euris.academy.teslabattery_da.data.model.Robot;
import it.euris.academy.teslabattery_da.data.model.key.AssemblyLineRobotKey;
import it.euris.academy.teslabattery_da.utils.UT;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssemblyLineRobotDto implements Dto {

  private AssemblyLineRobotKey idAssemblyLineRobotKey;
  private String assemblyLineId;
  private String robotId;
  private String positionalOrder;
  
  @Override
  public AssemblyLineRobot toModel() {
    return AssemblyLineRobot.builder()
        .id(new AssemblyLineRobotKey(UT.toLong(assemblyLineId), UT.toLong(robotId)))
        .assemblyLine(new AssemblyLine(assemblyLineId))
        .robot(new Robot(robotId))
        .positionalOrder(UT.toInteger(positionalOrder))
        .build();
  }

}
