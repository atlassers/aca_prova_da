package it.euris.academy.teslabattery_da.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import it.euris.academy.teslabattery_da.data.model.ProductiveCycle;

public interface ProductiveCycleRepository extends JpaRepository<ProductiveCycle, Long>{

  @Query(value = "SELECT COUNT(*) FROM productive_cycle WHERE status = 'COMPLETATO'", nativeQuery = true)
  Integer getCompletedCycles();
  
  @Query(value = "SELECT COUNT(*) FROM productive_cycle WHERE status = 'FALLITO'", nativeQuery = true)
  Integer getFailedCycles();
  
  @Query(value = "SELECT COUNT(*) FROM productive_cycle", nativeQuery = true)
  Integer getTotalCycle();
  
  @Query(value = "SELECT pc.status, COUNT(*) FROM productive_cycle pc GROUP BY pc.status", nativeQuery = true)
  Integer getFailedCyclesPerStatus();
}
