package it.euris.academy.teslabattery_da.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import com.fasterxml.jackson.annotation.JsonIgnore;
import it.euris.academy.teslabattery_da.data.archetype.Dto;
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
  
  @Column(name = "positional_order")
  private Integer positionalOrder;
  
  @ManyToOne
  @NotFound(action = NotFoundAction.IGNORE)
  @JoinColumn(name = "assembly_id")
  @JsonIgnore
  private AssemblyLine assemblyLineId;
  
  @Override
  public RobotDto toDto() {
    return RobotDto.builder()
        .id(id.toString())
        .task(task.toString())
        .positionalOrder(positionalOrder.toString())
        .build();
  }
}
