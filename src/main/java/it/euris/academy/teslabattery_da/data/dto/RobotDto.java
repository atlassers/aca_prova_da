package it.euris.academy.teslabattery_da.data.dto;

import it.euris.academy.teslabattery_da.data.archetype.Dto;
import it.euris.academy.teslabattery_da.data.archetype.Model;
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
  
  private String positionalOrder; 
  
  @Override
  public Robot toModel() {
    return Robot.builder()
        .id(UT.toLong(id))
        .task(UT.getRobotTask(task))
        .positionalOrder(UT.toInteger(positionalOrder))
        .build();
  }

}
