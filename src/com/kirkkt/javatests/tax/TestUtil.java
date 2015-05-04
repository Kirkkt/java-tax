package com.kirkkt.javatests.tax;

import com.kirkkt.java.tax.forms.Form;
import com.kirkkt.java.tax.forms.Entry;
import com.kirkkt.java.tax.forms.BooleanEntry;
import com.kirkkt.java.tax.forms.IntEntry;

import com.google.common.base.Preconditions;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class TestUtil {

  private TestUtil() {}  // COV_NF_LINE

  public static final String TEST_DATA_FOLDER = System.getenv("GITHUB_DIR")
      + "/../vim_notes/java_programs/data/com/kirkkt/javatests/tax";

  public static UnmodifiableIterator<String> getGold(String fileName) {
    BufferedReader br;
    String line;
    ImmutableList.Builder<String> goldBuilder = ImmutableList.<String>builder();
    try {
      br = new BufferedReader(new FileReader(fileName));
      while ((line = br.readLine()) != null) {
        goldBuilder.add(line);
      }
      br.close();
    } catch (IOException e) {
      throw new IllegalArgumentException("Failed to read file " + fileName + " due to error " + e);
    }
    return goldBuilder.build().iterator();
  }

  public static Map<String, String> getGoldMap(String fileName) {
    BufferedReader br;
    String line;
    ImmutableMap.Builder<String, String> goldBuilder = ImmutableMap.<String, String>builder();
    try {
      br = new BufferedReader(new FileReader(fileName));
      while ((line = br.readLine()) != null) {
        if (line.startsWith("# ")) {
          // comments
          continue;
        }
        String[] parts = line.split(": ");
        goldBuilder.put(parts[0], (parts.length < 2) ? "" : parts[1]);
      }
      br.close();
    } catch (IOException e) {
      throw new IllegalArgumentException("Failed to read file " + fileName + " due to error " + e);
    }
    return goldBuilder.build();
  }

  public static void checkContains(Set<?> set, Object item) {
    Preconditions.checkState(set.contains(item), "Not true that set " + set + " contains item "
        + item);
  }

  public static void checkFormEntryEquals(Form form, String key, String expected) {
    Preconditions.checkState(form.keySet().contains(key), "Key " + key + " cannot be found in form "
        + form.getFormType() + " for tax year " + form.getTaxYear());
    String actual = "";
    if (form.getValue(key) instanceof List<?>) {
      for (Object item : ((List<?>) form.getValue(key))) {
        Entry<?> entry = (Entry) item;
        if (item instanceof IntEntry) {
          actual += entry.getDescription() + " ";
        }
        actual += String.valueOf(entry.getValue()) + " ";
      }
      actual = actual.trim();
    } else {
      actual = String.valueOf(form.getValue(key));
    }
    Preconditions.checkState(actual.equals(expected),
        "Not true that entry " + key + " in form " + form.getFormType() + " for tax year "
            + form.getTaxYear() + " has value [" + expected + "]. Actual: ["
            + actual + "].");
  }
}
