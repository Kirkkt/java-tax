package com.kirkkt.java.tax.forms;

import java.util.ArrayList;
import java.util.List;

public class BooleanListEntry extends Entry<List<BooleanEntry>> {

  private String trueWord;
  private String falseWord;

  @Override
  void init() {
    super.init();
    trueWord = "[X]";
    falseWord = "[ ]";
  }

  @Override
  public List<BooleanEntry> getDefaultValue() {
    return new ArrayList<BooleanEntry>();
  }

  @Override
  public void readFromLine(String line, String prefix)
      throws IllegalArgumentException {
    super.readFromLine(line, prefix);
    String[] toParse = line.split(prefix, 2)[1].split(" ");
    for (String item : toParse) {
      BooleanEntry entry = new BooleanEntry();
      entry.setValue(Boolean.parseBoolean(item));
      value.add(entry);
    }
  }

  @Override
  public String print() {
    for (BooleanEntry item : value) {
      if (item.isDirty()) {
        return forcePrint();
      }
    }
    return "";
  }

  @Override
  public String forcePrint() {
    String result = "";
    result += getId() + ":\n";
    for (BooleanEntry entry : value) {
      if (!falseWord.isEmpty() || entry.getValue()) {
        result += "  " + (entry.getDescription().isEmpty() ? "" : (entry.getDescription() + " "))
            + (entry.getValue() ? trueWord : falseWord) + "\n";
      }
    }
    return result;
  }

  @Override
  public boolean isEqualTo(String expected) {
    String actual = "";
    for (BooleanEntry item : value) {
      actual += item.getValue() + " ";
    }
    return actual.trim().equals(expected);
  }

  public BooleanListEntry setDisplayWords(String trueWord, String falseWord) {
    this.trueWord = trueWord;
    this.falseWord = falseWord;
    return this;
  }
}
