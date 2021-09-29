package it.euris.academy.teslabattery_da.data.model;

import java.time.Instant;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import it.euris.academy.teslabattery_da.data.archetype.Dto;
import it.euris.academy.teslabattery_da.data.archetype.Model;
import it.euris.academy.teslabattery_da.data.dto.FormulaDto;
import it.euris.academy.teslabattery_da.utils.UT;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "formula")
@Entity
public class Formula implements Model {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @Column(name = "quantity")
  private Integer quantity;
  
  @Column(name = "unit")
  private Integer unit;
  
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "assembly_line_id", referencedColumnName = "id")
  private AssemblyLine assemblyLineId;
  
  @OneToMany(mappedBy = "formulaId")
  private List<Component> components;
  
  @Override
  public FormulaDto toDto() {
    return FormulaDto.builder()
        .id(UT.numberToString(id))
        .quantity(UT.numberToString(quantity))
        .unit(UT.numberToString(unit))
        .assemblyLineId(UT.numberToString(assemblyLineId.getId()))
        .build();
  }

}
