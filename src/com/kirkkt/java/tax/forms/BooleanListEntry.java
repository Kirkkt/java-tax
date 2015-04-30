package com.kirkkt.java.tax.forms;

import com.kirkkt.java.tax.Parser;

import java.util.ArrayList;
import java.util.List;

public class BooleanListEntry extends Entry<List<SingleLineBooleanEntry>> {

  private String trueWord;
  private String falseWord;

  public BooleanListEntry setDisplayWords(String trueWord, String falseWord) {
    this.trueWord = trueWord;
    this.falseWord = falseWord;
    return this;
  }

  @Override
  public void readFromLine(String line, String prefix) throws IllegalArgumentException, NumberFormatException {
    super.readFromLine(line, prefix);
    String[] toParse = (line.split(prefix, 2)[1]).split(" ");
    ArrayList<SingleLineBooleanEntry> list = new ArrayList<SingleLineBooleanEntry>();
    for (int i = 0; i < toParse.length; i += 2) {
      SingleLineBooleanEntry entry = new SingleLineBooleanEntry();
      entry.setId(toParse[i]);
      entry.setValue(Parser.parseBoolean(toParse[i + 1], line));
      entry.setDisplayWords(trueWord, falseWord);
      list.add(entry);
    }
    setValue(list);
  }

  @Override
  public String forcePrint() {
    String result = getId() + ":\n";
    for (SingleLineBooleanEntry item : getValue()) {
      result += "  " + item.forcePrint() + "\n";
    }
    return result;
  }
}

class SingleLineBooleanEntry extends BooleanEntry {
  @Override
  public String toString() {
    return getId() + ": " + (getValue() ? getTrueWord() : getFalseWord()) + "\n";
  }
}
