package com.kirkkt.java.tax.forms;

import com.google.common.base.Strings;

public class Entry<T> {

  T value;

  private String id;
  private boolean mustPrint;

  private boolean dirty;
  private String description;

  public Entry() {
    init();
  }

  void init() {
    dirty = false;
    value = getDefaultValue();
  }

  public void reset() {
    init();
  }

  public Entry<T> setId(String id) {
    this.id = id;
    return this;
  }

  public Entry<T> setMustPrint(boolean mustPrint) {
    this.mustPrint = mustPrint;
    return this;
  }

  public Entry<T> setDescription(String description) {
    this.description = description;
    return this;
  }

  public String getId() {
    return id;
  }

  public boolean shouldPrint() {
    return mustPrint || dirty;
  }

  public T getValue() {
    return value;
  }

  public void setValue(T value) {
    this.value = value;
    if (value != getDefaultValue() || (value != null && !value.equals(getDefaultValue()))) {
      this.dirty = true;
    }
  }

  public T getDefaultValue() {
    return null;
  }

  public boolean isDirty() {
    return dirty;
  }

  public String print() {
    if (shouldPrint()) {
      return forcePrint();
    }
    return "";
  }

  public String getDescription() {
    return description;
  }

  public void readFromLine(String line, String prefix)
      throws IllegalArgumentException {
    if (!line.startsWith(prefix)) {
      throw new IllegalArgumentException("line " + line + " doesn't start with " + prefix);
    }
    setId(prefix.trim().split(":")[0]);
    this.dirty = true;
  }

  public String forcePrint() {
    String result = id;
    if (!Strings.isNullOrEmpty(description)) {
      result += " " + description;
    }
    result += ":\n  " + value + "\n";
    return result;
  }

  public boolean isEqualTo(String expected) {
    return String.valueOf(value).equals(expected);
  }
}
