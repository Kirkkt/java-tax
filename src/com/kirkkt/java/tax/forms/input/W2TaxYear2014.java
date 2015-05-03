package com.kirkkt.java.tax.forms.input;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;

import com.kirkkt.java.tax.Parser;
import com.kirkkt.java.tax.TaxUtil;
import com.kirkkt.java.tax.forms.IntEntry;
import com.kirkkt.java.tax.forms.Entry;
import com.kirkkt.java.tax.forms.BooleanEntry;
import com.kirkkt.java.tax.forms.StringEntry;
import com.kirkkt.java.tax.forms.IntListEntry;
import com.kirkkt.java.tax.forms.BooleanListEntry;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.List;

public class W2TaxYear2014 extends InputForm {
// TODO(kirktdev): use collections instead of declaring individual entries

  private static final Map<String, String> STRING_ENTRY_KEY_MAP = ImmutableMap.of(
      "employer address", "Employer address",
      "employer identification number", "Empyter identification number",
      "b15", "State",
      "employer state id number", "Employer state ID number",
      "b20", "Locality name"
      );
  private static final Map<String, String> INT_ENTRY_KEY_MAP =
      ImmutableMap.<String, String>builder()
          .put("b1", "Wages, tips, other compensation")
          .put("b2", "Federal income tax withheld")
          .put("b3", "Social security wages")
          .put("b4", "Secial security tax withheld")
          .put("b5", "Medicare wages and tips")
          .put("b6", "Medicare tax withheld")
          .put("b7", "Social security tips")
          .put("b8", "Allocated tips")
          .put("b10", "Dependent care benefits")
          .put("b11", "Nonqualified plans")
          .put("b16", "State wages, tipc, etc.")
          .put("b17", "State income tax")
          .put("b18", "Local wages, tips, etc.")
          .put("b19", "Local income tax")
          .build();
  private static final Map<String, String> BOOLEAN_LIST_ENTRY_KEY_MAP = ImmutableMap.of(
      "b13", ""
  );
  private static final Map<String, List<String>> BOOLEAN_LIST_ENTRY_SUBENTRY_KEY_MAP =
      ImmutableMap.of(
          "b13", Arrays.asList(
              "Statutory employee",
              "Retirement plan",
              "Third-party sick pay"
          ));
  private static final Map<String, String> INT_LIST_ENTRY_KEY_MAP = ImmutableMap.of(
      "b12","See instrubtions for box 12",
      "b14","Others"
  );

  private HashMap<String, Entry<?>> entries = new LinkedHashMap<String, Entry<?>>();

  private IntEntry b1 = new IntEntry();
  private IntEntry b2 = new IntEntry();
  private StringEntry bEmployerAddress = new StringEntry();
  private IntEntry b3 = new IntEntry();
  private IntEntry b4 = new IntEntry();
  private IntEntry b5 = new IntEntry();
  private IntEntry b6 = new IntEntry();
  private IntEntry b7 = new IntEntry();
  private IntEntry b8 = new IntEntry();
  private StringEntry bEmployerIdentificationNumber = new StringEntry();
  private IntEntry b10 = new IntEntry();
  private IntEntry b11 = new IntEntry();
  private IntListEntry b12 = new IntListEntry();
  private BooleanListEntry b13 = new BooleanListEntry();
  private IntListEntry b14 = new IntListEntry();
  private StringEntry b15 = new StringEntry();
  private StringEntry bEmployerStateIdNumber = new StringEntry();
  private IntEntry b16 = new IntEntry();
  private IntEntry b17 = new IntEntry();
  private IntEntry b18 = new IntEntry();
  private IntEntry b19 = new IntEntry();
  private StringEntry b20 = new StringEntry();

  private boolean fileImported = false;

  private final TaxUtil util = new TaxUtil();

  public W2TaxYear2014() {}

  @Override
  public String getFormType() {
    return "W2";
  }

  @Override
  public int getTaxYear() {
    return 2014;
  }

  @Override
  public void readFromFile(String fileName) {
    if (fileImported) {
      throw new IllegalStateException("Form " + getFormType() + " for tax year " + getTaxYear()
          + " can't read from files more than once.");
    }
    fileImported = true;

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
        if (STRING_ENTRY_KEY_MAP.keySet().contains(header)) {
          StringEntry entry = new StringEntry();
          entry.readFromLine(line, header + ": ");
          entry.setDescription(STRING_ENTRY_KEY_MAP.get(header));
          entries.put(header, entry);
        } else if (INT_ENTRY_KEY_MAP.keySet().contains(header)) {
          IntEntry entry = new IntEntry();
          entry.readFromLine(line, header + ": ");
          entry.setDescription(INT_ENTRY_KEY_MAP.get(header));
          entries.put(header, entry);
        } else if (BOOLEAN_LIST_ENTRY_KEY_MAP.keySet().contains(header)) {
          BooleanListEntry entry = new BooleanListEntry();
          entry.readFromLine(line, header + ": ");
          entry.setDescription(BOOLEAN_LIST_ENTRY_KEY_MAP.get(header));
          for (BooleanEntry subentry : entry.getValue()) {
            subentry.setDescription(BOOLEAN_LIST_ENTRY_SUBENTRY_KEY_MAP.get(header).iterator().next());
          }
          entries.put(header, entry);
        } else if (INT_LIST_ENTRY_KEY_MAP.keySet().contains(header)) {
          IntListEntry entry = new IntListEntry();
          entry.readFromLine(line, header + ": ");
          entry.setDescription(INT_LIST_ENTRY_KEY_MAP.get(header));
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

  @Override
  public void prod() {
    readFromFile(TaxUtil.DATA_FOLDER + "/forms/input/w2taxyear2014.txt");
    System.out.print(this);
  }

  // TODO(kirktdev): extract to Forms abstract class

  public boolean doesKeyExist(String key) {
    return entries.keySet().contains(key);
  }

  public Set<String> keySet() {
    return entries.keySet();
  }

  public boolean isEntryValueEqual(String key, String expected) {
    return doesKeyExist(key) && entries.get(key).isEqualTo(expected);
    // return entries.get(key).getClass();
  }

  /** Wages, tips, other compensation. */
  public IntEntry getB1() {
    return b1;
  }

  /** Federal income tax withheld. */
  public IntEntry getB2() {
    return b2;
  }

  /** Employer address */
  public StringEntry getBEmployerAddress() {
    return bEmployerAddress;
  }
  /** Social security wages. */
  public IntEntry getB3() {
    return b3;
  }

  /** Social security tax withheld. */
  public IntEntry getB4() {
    return b4;
  }

  /** Medicare wages and tips. */
  public IntEntry getB5() {
    return b5;
  }

  /** Medicare tax withheld. */
  public IntEntry getB6() {
    return b6;
  }

  /** Social security tips. */
  public IntEntry getB7() {
    return b7;
  }

  /** Allocated tips. */
  public IntEntry getB8() {
    return b8;
  }

  /** Employer identification number */
  public StringEntry getBEmployerIdentificationNumber() {
    return bEmployerIdentificationNumber;
  }

  /** Dependent care benefits. */
  public IntEntry getB10() {
    return b10;
  }

  /** Nonqualified plans. */
  public IntEntry getB11() {
    return b11;
  }

  /** Annotation codes. */
  public IntListEntry getB12() {
    return b12;
  }

  /**
   * Special treatment checkboxes.
   *
   * [0] Statutory employee.
   * [1] Retirement plan.
   * [2] Thrid-party sick pay.
   */
  public BooleanListEntry getB13() {
    return b13;
  }

  /** Other */
  public IntListEntry getB14() {
    return b14;
  }

  /** State */
  public StringEntry getB15() {
    return b15;
  }

  /** Employer state ID number */
  public StringEntry getBEmployerStateIdNumber() {
    return bEmployerStateIdNumber;
  }

  /** State wages, tips, etc. */
  public IntEntry getB16() {
    return b16;
  }

  /** State income tax. */
  public IntEntry getB17() {
    return b17;
  }

  /** Local income wages, tips, etc. */
  public IntEntry getB18() {
    return b18;
  }

  /** Local income tax. */
  public IntEntry getB19() {
    return b19;
  }

  /** Locality name. */
  public StringEntry getB20() {
    return b20;
  }

  @Override
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
