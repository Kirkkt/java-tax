package com.kirkkt.java.tax;

import java.util.Map;

public class TaxMath {

  private TaxMath() {}

  public static int getSum(Map<String, Integer> map) {
    int result = 0;
    for (String key : map.keySet()) {
      result += map.get(key);
    }
    return result;
  }
}
