package it.euris.academy.teslabattery_da.data.dto;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import it.euris.academy.teslabattery_da.data.archetype.Dto;
import it.euris.academy.teslabattery_da.data.archetype.Model;
import it.euris.academy.teslabattery_da.data.model.AssemblyLine;
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
public class AssemblyLineDto implements Dto {
  
  private String id;
  
  private String name;
  
  private String completionTime;
  
  @JsonIgnore
  private List<RobotDto> robots;
  
  @Override
  public AssemblyLine toModel() {
    return AssemblyLine.builder()
        .id(UT.toLong(id))
        .name(name)
        .completionTime(UT.toLong(completionTime))
        .build();
  }

}
