package com.kirkkt.java.tax.forms.input;

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
  private static final Map<String, List<String>> BOOLEAN_LIST_SUBENTRY_KEY_MAP =
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
  public Map<String, String> getStringEntryKeyMap() {
    return STRING_ENTRY_KEY_MAP;
  }

  @Override
  public Map<String, String> getIntEntryKeyMap() {
    return INT_ENTRY_KEY_MAP;
  }

  @Override
  public Map<String, String> getBooleanListEntryKeyMap() {
    return BOOLEAN_LIST_ENTRY_KEY_MAP;
  }

  @Override
  public Map<String, List<String>> getBooleanListSubentryKeyMap() {
    return BOOLEAN_LIST_SUBENTRY_KEY_MAP;
  }

  @Override
  public Map<String, String> getIntListEntryKeyMap() {
    return INT_LIST_ENTRY_KEY_MAP;
  }

  @Override
  public void prod() {
    readFromFile(TaxUtil.DATA_FOLDER + "/forms/input/w2taxyear2014.txt");
    System.out.print(this);
  }
}
