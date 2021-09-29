package it.euris.academy.teslabattery_da.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import it.euris.academy.teslabattery_da.data.model.Formula;

public interface FormulaRepository extends JpaRepository<Formula, Long> {

}
