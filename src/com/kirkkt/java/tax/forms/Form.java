package com.kirkkt.java.tax.forms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.LinkedHashMap;

/** A form. */
public abstract class Form {

  private boolean hasReadFromFile = false;

  // TODO(kirktdev): make private
  public HashMap<String, Entry<?>> entries = new LinkedHashMap<String, Entry<?>>();

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

  // TODO(kirktdev): make abstract
  public Map<String, String> getBooleanEntryKeyMap() { return null;}
  public Map<String, String> getIntEntryKeyMap() { return null;}
  public Map<String, String> getStringEntryKeyMap() { return null;}
  public Map<String, String> getBooleanListEntryKeyMap() { return null;}
  public Map<String, List<String>> getBooleanListSubentryKeyMap() { return null;}
  public Map<String, String> getIntListEntryKeyMap() { return null;}

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
        if (line.equals("w2 " + getTaxYear()) || line.startsWith("# ")) {
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
          for (BooleanEntry subentry : entry.getValue()) {
            subentry.setDescription(getBooleanListSubentryKeyMap().get(header).iterator().next());
          }
          entries.put(header, entry);
        } else if (getIntListEntryKeyMap().keySet().contains(header)) {
          IntListEntry entry = new IntListEntry();
          entry.readFromLine(line, header + ": ");
          entry.setDescription(getIntListEntryKeyMap().get(header));
          entries.put(header, entry);
        } else {
          throw new IllegalArgumentException("Invalid input line: " + line);
        }
      }
      br.close();
    } catch (IOException e) {
      throw new IllegalArgumentException("Failed to read file " + fileName + " due to error " + e);
    }
  }

}
