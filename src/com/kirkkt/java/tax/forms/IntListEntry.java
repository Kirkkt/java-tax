package com.kirkkt.java.tax.forms;

import com.kirkkt.java.tax.Parser;

import com.google.common.base.Strings;

import java.util.List;
import java.util.ArrayList;

public class IntListEntry extends Entry<List<IntEntry>> {

  @Override
  public List<IntEntry> getDefaultValue() {
    return new ArrayList<IntEntry>();
  }

  @Override
  public void readFromLine(String line, String prefix)
      throws IllegalArgumentException {
    super.readFromLine(line, prefix);
    String[] toParse = line.split(prefix, 2)[1].split(" ");
    if ((toParse.length / 2 * 2) != toParse.length) {
      throw new IllegalArgumentException("List must contain even number of strings.");
    }
    for (int i = 0; i < toParse.length ; i += 2) {
      IntEntry entry = new IntEntry();
      entry.setDescription(toParse[i]);
      entry.setValue(Parser.parseAndRound(toParse[i + 1], line));
      value.add(entry);
    }
  }

  @Override
  public String forcePrint() {
    String result = getId();
    if (!Strings.isNullOrEmpty(getDescription())) {
      result += " " + getDescription();
    }
    result += ":\n";
    for (IntEntry entry : value) {
      result += "  " + (entry.getDescription().isEmpty() ? "" : (entry.getDescription() + " "))
          + entry.getValue() + "\n";
    }
    return result;
  }

  @Override
  public boolean isEqualTo(String expected) {
    String actual = "";
    for (IntEntry item : value) {
      if (item.getDescription().isEmpty()) {
        actual += item.getValue() + " ";
      } else {
        actual += item.getDescription() + " " + item.getValue() + " ";
      }
    }
    return actual.trim().equals(expected);
  }

  public int getSum() {
    int result = 0;
    for (IntEntry entry : value) {
      result += entry.getValue();
    }
    return result;
  }
}
