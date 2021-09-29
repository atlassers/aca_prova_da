package it.euris.academy.teslabattery_da.data.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import it.euris.academy.teslabattery_da.data.archetype.Model;
import it.euris.academy.teslabattery_da.data.dto.AssemblyLineDto;
import it.euris.academy.teslabattery_da.utils.UT;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "assembly_line")
@Entity
public class AssemblyLine implements Model {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @Column(name = "name")
  private String name;
  
  @Column(name = "completion_time")
  private Long completionTime;
  
  @OneToMany(mappedBy = "assemblyLine")
  @Builder.Default
  @JsonIgnore
  private Set<AssemblyLineRobot> assemblyLineRobots = new HashSet<AssemblyLineRobot>();
  
  public AssemblyLine(String assemblyId) {
    this.id = Long.valueOf(assemblyId);
  }

  @Override
  public AssemblyLineDto toDto() {
    return AssemblyLineDto.builder()
        .id(UT.numberToString(id))
        .name(name)
        .completionTime(UT.numberToString(completionTime))
        .build();
  }
}
