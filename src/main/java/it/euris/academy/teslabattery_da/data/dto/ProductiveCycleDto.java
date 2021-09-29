package it.euris.academy.teslabattery_da.data.dto;

import it.euris.academy.teslabattery_da.data.archetype.Dto;
import it.euris.academy.teslabattery_da.data.model.AssemblyLine;
import it.euris.academy.teslabattery_da.data.model.ProductiveCycle;
import it.euris.academy.teslabattery_da.utils.UT;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductiveCycleDto implements Dto {
  
  private String id;
  
  private String startDate;
  
  private String endDate;
  
  private String status;
  
  private String dateStatus;
  
  private String assemblyLineId;
  
  @Override
  public ProductiveCycle toModel() {
    return ProductiveCycle.builder()
        .id(UT.toLong(id))
        .startDate(UT.toInstant(startDate))
        .endDate(UT.toInstant(endDate))
        .status(UT.getCycleStatus(status))
        .dateStatus(UT.toInstant(dateStatus))
        .assemblyLineId(AssemblyLine.builder().id(UT.toLong(id)).build())
        .build();
  }

}
