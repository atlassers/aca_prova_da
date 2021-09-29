package it.euris.academy.teslabattery_da.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import it.euris.academy.teslabattery_da.data.model.AssemblyLine;

public interface AssemblyLineRepository extends JpaRepository<AssemblyLine, Long> {

}
