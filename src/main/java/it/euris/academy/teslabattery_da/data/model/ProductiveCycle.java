package it.euris.academy.teslabattery_da.data.model;

import java.time.Instant;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import it.euris.academy.teslabattery_da.data.archetype.Dto;
import it.euris.academy.teslabattery_da.data.archetype.Model;
import it.euris.academy.teslabattery_da.data.dto.AssemblyLineDto;
import it.euris.academy.teslabattery_da.data.dto.ProductiveCycleDto;
import it.euris.academy.teslabattery_da.data.enums.CycleStatus;
import it.euris.academy.teslabattery_da.utils.UT;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "productive_cycle")
@Entity
public class ProductiveCycle implements Model {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @Column(name = "start_date")
  private Instant startDate;
  
  @Column(name = "end_date")
  private Instant endDate;
  
  @Column(name = "status")
  @Enumerated(EnumType.STRING)
  private CycleStatus status;
  
  @Column(name = "date_status")
  private Instant dateStatus;
  
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "assembly_line_id", referencedColumnName = "id")
  private AssemblyLine assemblyLineId;
  
  @Override
  public ProductiveCycleDto toDto() {
    return ProductiveCycleDto.builder()
        .id(UT.numberToString(id))
        .startDate(UT.fromInstant(startDate))
        .endDate(UT.fromInstant(endDate))
        .status(status == null ? null : status.toString())
        .dateStatus(UT.fromInstant(dateStatus))
        .assemblyLineId((UT.numberToString(assemblyLineId.getId())))
        .build();
  }

}
