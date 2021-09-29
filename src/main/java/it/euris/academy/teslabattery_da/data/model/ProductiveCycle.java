package it.euris.academy.teslabattery_da.data.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import it.euris.academy.teslabattery_da.data.archetype.Dto;
import it.euris.academy.teslabattery_da.data.archetype.Model;
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
  
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "assembly_line_id", referencedColumnName = "id")
  private AssemblyLine assemblyLineId;
  
  
  @Override
  public Dto toDto() {
    // TODO Auto-generated method stub
    return null;
  }

}
