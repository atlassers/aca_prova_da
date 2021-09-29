package it.euris.academy.teslabattery_da.data.model;

import java.util.Set;
import java.util.HashSet;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import it.euris.academy.teslabattery_da.data.archetype.Model;
import it.euris.academy.teslabattery_da.data.dto.RobotDto;
import it.euris.academy.teslabattery_da.data.enums.RobotTask;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "robot")
public class Robot implements Model {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @Column(name = "task")
  @Enumerated(EnumType.STRING)
  private RobotTask task;
  
  @OneToMany(mappedBy = "robot")
  @Builder.Default
  @JsonIgnore
  private Set<AssemblyLineRobot> assemblyLineRobots = new HashSet<AssemblyLineRobot>();
  
  public Robot(String robotId) {
    this.id = Long.valueOf(robotId);
  }
  
  @Override
  public RobotDto toDto() {
    return RobotDto.builder()
        .id(id.toString())
        .task(task.toString())
        .build();
  }
}
