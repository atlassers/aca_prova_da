package it.euris.academy.teslabattery_da.data.model.key;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class AssemblyLineRobotKey implements Serializable {
  
  private static final long serialVersionUID = 1L;
  
  @Column(name = "assembly_line_id")
  Long assemblyLineId;
  
  @Column(name = "robot_id")
  Long robotId;

}
