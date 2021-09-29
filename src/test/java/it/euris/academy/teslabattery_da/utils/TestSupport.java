package it.euris.academy.teslabattery_da.utils;

import java.util.List;
import it.euris.academy.teslabattery_da.data.model.AssemblyLine;

public class TestSupport {

  public static AssemblyLine createAssemblyLine(Long id) {
    return AssemblyLine.builder().id(id).completionTime(5L).name("First AssemblyLine").build();
  }
  public static List<AssemblyLine> createAssemblyLineList() {
    return List.of(createAssemblyLine(1L), createAssemblyLine(2L));
  }
}
