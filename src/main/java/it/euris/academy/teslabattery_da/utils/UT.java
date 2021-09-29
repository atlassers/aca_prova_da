package it.euris.academy.teslabattery_da.utils;

import java.time.Instant;

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
  
//  public static DeliveryType getDeliveryType(String value) {
//    if(value == null)
//      return null;
//    
//    for(DeliveryType delivery : DeliveryType.values()) {
//      if(delivery.name().equals(value)) 
//        return delivery;
//      }
//      return null;
//  }
}
