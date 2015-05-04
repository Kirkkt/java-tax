package com.kirkkt.java.tax.forms;

import com.google.common.collect.ImmutableMap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/** A form. */
public abstract class Form {

  private boolean hasReadFromFile = false;

  private HashMap<String, Entry<?>> entries = new LinkedHashMap<String, Entry<?>>();

  /**
   * Gets the type of this form.
   *
   * @return form type, e.g. "W2" or "F1040 Schedule A"
   */
  public abstract String getFormType();

  /**
   * Gets the tax year this form is designed for.
   *
   * @return tax year, e.g. 2014
   */
  public abstract int getTaxYear();

  public Map<String, String> getBooleanEntryKeyMap() {
    return ImmutableMap.<String, String>of();
  }

  public Map<String, String> getIntEntryKeyMap() {
    return ImmutableMap.<String, String>of();
  }

  public Map<String, String> getStringEntryKeyMap() {
    return ImmutableMap.<String, String>of();
  }

  public Map<String, String> getBooleanListEntryKeyMap() {
    return ImmutableMap.<String, String>of();
  }

  public Map<String, List<String>> getBooleanListSubentryKeyMap() {
    return ImmutableMap.<String, List<String>>of();
  }

  public Map<String, String> getIntListEntryKeyMap() {
    return ImmutableMap.<String, String>of();
  }


  /**
   * Populate the form instance with the input from a file
   *
   * @param fileName the absolute path to the file
   */
  public void readFromFile(String fileName) {
    if (hasReadFromFile) {
      throw new IllegalStateException("Form " + getFormType() + " for tax year " + getTaxYear()
          + " can't read from files more than once.");
    }
    hasReadFromFile = true;

    BufferedReader br;
    String line;

    try {
      br = new BufferedReader(new FileReader(fileName));
      while ((line = br.readLine()) != null) {
        if (line.equals(getFormType() + " " + getTaxYear()) || line.startsWith("# ")) {
          // heading or comments
          continue;
        }

        String header = line.split(": ")[0];
        if (getStringEntryKeyMap().keySet().contains(header)) {
          StringEntry entry = new StringEntry();
          entry.readFromLine(line, header + ": ");
          entry.setDescription(getStringEntryKeyMap().get(header));
          entries.put(header, entry);
        } else if (getIntEntryKeyMap().keySet().contains(header)) {
          IntEntry entry = new IntEntry();
          entry.readFromLine(line, header + ": ");
          entry.setDescription(getIntEntryKeyMap().get(header));
          entries.put(header, entry);
        } else if (getBooleanEntryKeyMap().keySet().contains(header)) {
          BooleanEntry entry = new BooleanEntry();
          entry.readFromLine(line, header + ": ");
          entry.setDescription(getBooleanEntryKeyMap().get(header));
          entries.put(header, entry);
        } else if (getBooleanListEntryKeyMap().keySet().contains(header)) {
          BooleanListEntry entry = new BooleanListEntry();
          entry.readFromLine(line, header + ": ");
          entry.setDescription(getBooleanListEntryKeyMap().get(header));
          Iterator<String> descriptionIterator = getBooleanListSubentryKeyMap().get(header).iterator();
          for (BooleanEntry subentry : entry.getValue()) {
            subentry.setDescription(descriptionIterator.next());
          }
          entries.put(header, entry);
        } else if (getIntListEntryKeyMap().keySet().contains(header)) {
          IntListEntry entry = new IntListEntry();
          entry.readFromLine(line, header + ": ");
          entry.setDescription(getIntListEntryKeyMap().get(header));
          entries.put(header, entry);
        } else {
          throw new IllegalArgumentException("Invalid input line: [" + line + "]");
        }
      }
      br.close();
    } catch (IOException e) {
      throw new IllegalArgumentException("Failed to read file " + fileName + " due to error " + e);
    }
  }

  public Set<String> keySet() {
    return entries.keySet();
  }

  public boolean isEntryValueEqual(String key, String expected) {
    return keySet().contains(key) && entries.get(key).isEqualTo(expected);
  }

  public Object getValue(String key) {
    if (keySet().contains(key)) {
      return null;
    }
    return entries.get(key).getValue();
  }

  public String toString() {
    String result = "";
    result += getFormType() + " Tax Year " + getTaxYear() + "\n";
    result += "-----------------------\n";
    result += "\n";

    for (String key : entries.keySet()) {
      result += ((Entry) entries.get(key)).print();
    }
    result += "\n-----------------------\n";

    return result;
  }
}
