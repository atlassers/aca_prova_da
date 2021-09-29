package it.euris.academy.teslabattery_da.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import it.euris.academy.teslabattery_da.data.model.Robot;

public interface RobotRepository extends JpaRepository<Robot, Long> {

}
