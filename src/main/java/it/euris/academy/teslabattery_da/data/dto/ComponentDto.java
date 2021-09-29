package it.euris.academy.teslabattery_da.data.dto;

import it.euris.academy.teslabattery_da.data.archetype.Dto;
import it.euris.academy.teslabattery_da.data.model.Component;
import it.euris.academy.teslabattery_da.data.model.Formula;
import it.euris.academy.teslabattery_da.utils.UT;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ComponentDto implements Dto {
  
  private String id;
  
  private String name;
  
  private String isDangerous;
  
  private String formulaId;
  
  @Override
  public Component toModel() {
    return Component.builder()
        .id(UT.toLong(id))
        .name(name)
        .isDangerous(Boolean.parseBoolean(isDangerous))
        .formulaId(Formula.builder().id(UT.toLong(formulaId)).build())
        .build();
  }

}
