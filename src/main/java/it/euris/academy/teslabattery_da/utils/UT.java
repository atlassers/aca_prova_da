package it.euris.academy.teslabattery_da.utils;

import java.time.Instant;
import it.euris.academy.teslabattery_da.data.enums.CycleStatus;
import it.euris.academy.teslabattery_da.data.enums.RobotTask;

public class UT {

  public static Long toLong(String value) {
    return value == null ? null : Long.parseLong(value);
  }

  public static Double toDouble(String value) {
    return value == null ? null : Double.parseDouble(value);
  }

  public static Instant toInstant(String value) {
    return value == null ? null : Instant.parse(value);
  }

  public static String fromInstant(Instant value) {
    return value == null ? null : value.toString();
  }
  
  public static String numberToString(Number value) {
    return value == null ? null : value.toString();
  }
  
  public static String dateToString(Instant value) {
    return value == null ? null : value.toString();
  }

  public static Integer toInteger(String value) {
    return value == null ? null : Integer.parseInt(value);
  }
  
  public static RobotTask getRobotTask(String value) {
    if(value == null)
      return null;
    
    for(RobotTask task : RobotTask.values()) {
      if(task.name().equals(value)) 
        return task;
      }
      return null;
  }
  
  public static CycleStatus getCycleStatus(String value) {
    if(value == null)
      return null;
    
    for(CycleStatus status : CycleStatus.values()) {
      if(status.name().equals(value)) 
        return status;
      }
      return null;
  }
}
