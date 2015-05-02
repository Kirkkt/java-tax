package com.kirkkt.java.tax.forms;

import com.kirkkt.java.tax.Parser;

public class IntEntry extends Entry<Integer> {

  @Override
  void init() {
    super.init();
    value = 0;
  }

  @Override
  public void readFromLine(String line, String prefix)
      throws IllegalArgumentException {
    super.readFromLine(line, prefix);
    setValue(Parser.parseAndRound(line.split(prefix, 2)[1], line));
  }
}
