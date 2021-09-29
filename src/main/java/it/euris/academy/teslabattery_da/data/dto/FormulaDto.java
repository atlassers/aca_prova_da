package it.euris.academy.teslabattery_da.data.dto;

import it.euris.academy.teslabattery_da.data.archetype.Dto;
import it.euris.academy.teslabattery_da.data.archetype.Model;
import it.euris.academy.teslabattery_da.data.model.AssemblyLine;
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
public class FormulaDto implements Dto {
  
  private String id;
  
  private String quantity;
  
  private String unit;
  
  private String assemblyLineId;
  
  //private String components;
  
  @Override
  public Formula toModel() {
    return Formula.builder()
        .id(UT.toLong(id))
        .quantity(UT.toInteger(quantity))
        .unit(UT.toInteger(unit))
        .assemblyLineId(AssemblyLine.builder().id(UT.toLong(assemblyLineId)).build())
        .build();
  }

}
