package it.euris.academy.teslabattery_da.data.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import it.euris.academy.teslabattery_da.data.archetype.Dto;
import it.euris.academy.teslabattery_da.data.archetype.Model;
import it.euris.academy.teslabattery_da.data.dto.AssemblyLineRobotDto;
import it.euris.academy.teslabattery_da.data.model.key.AssemblyLineRobotKey;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "assembly_line_robot")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssemblyLineRobot implements Model {

  @EmbeddedId
  private AssemblyLineRobotKey id;
  
  @ManyToOne
  @MapsId("assemblyLineId")
  @JoinColumn(name = "assembly_line_id")
  private AssemblyLine assemblyLine;
  
  @ManyToOne
  @MapsId("robotId")
  @JoinColumn(name = "robot_id")
  private Robot robot;
  
  @Column(name = "positional_order")
  private Integer positionalOrder;

  @Override
  public AssemblyLineRobotDto toDto() {
    return AssemblyLineRobotDto.builder()
        .assemblyLineId(assemblyLine.getId().toString())
        .robotId(robot.getId().toString())
        .positionalOrder(positionalOrder.toString())
        .build();
  }
  
}
