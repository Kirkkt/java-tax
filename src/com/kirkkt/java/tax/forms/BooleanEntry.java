package com.kirkkt.java.tax.forms;


public class BooleanEntry extends Entry<Boolean> {

  private String trueWord;
  private String falseWord;

  @Override
  void init() {
    super.init();
    value = false;
  }

  @Override
  public void readFromLine(String line, String prefix)
      throws IllegalArgumentException {
    super.readFromLine(line, prefix);
    setValue(Boolean.parseBoolean(line.split(prefix, 2)[1]));
  }

  @Override
  public String forcePrint() {
    return getId() + ":\n  " + (getValue() ? getTrueWord() : getFalseWord()) + "\n";
  }

  public BooleanEntry setDisplayWords(String trueWord, String falseWord) {
    this.trueWord = trueWord;
    this.falseWord = falseWord;
    return this;
  }

  String getTrueWord() {
    return trueWord;
  }

  String getFalseWord() {
    return falseWord;
  }

}
