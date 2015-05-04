package com.kirkkt.java.tax.forms.input;

import com.google.common.collect.ImmutableMap;

import java.util.Arrays;
import java.util.Map;
import java.util.List;

public class F1099RTaxYear2014 extends InputForm {
  private static final Map<String, String> BOOLEAN_ENTRY_KEY_MAP =
      ImmutableMap.<String, String>builder()
          .put("b7checkbox", "IRA/SEP/SIMPLE")
          .build();
  private static final Map<String, String> STRING_ENTRY_KEY_MAP =
      ImmutableMap.<String, String>builder()
          .put("payer federal identification number", "")
          .put("payer name", "")
          .put("account number", "")
          .put("b7", "Distribution code")
          .put("b13", "Payer's state number")
          .build();
  private static final Map<String, String> INT_ENTRY_KEY_MAP =
      ImmutableMap.<String, String>builder()
          .put("b1", "Gross distribution")
          .put("b2a", "Taxable amount")
          .put("b3", "Capital gain")
          .put("b4", "Federal income tax withheld")
          .put("b5", "Employee contribution/designated Roth contribution or insurance premiums")
          .put("b6", "Net unrealized appreciate in employer's securities")
          .put("b8", "Other")
          .put("b9a", "Your percentage of total distribution")
          .put("b9b", "Total employee contributions")
          .put("b10", "Amount allocable to IRR within 5 years")
          .put("b11", "Year of designated Roth contribution")
          .put("b12", "State tax withheld")
          .put("b14", "State distribution")
          .build();
  private static final Map<String, String> BOOLEAN_LIST_ENTRY_KEY_MAP = ImmutableMap.of(
      "b2b", ""
  );
  private static final Map<String, List<String>> BOOLEAN_LIST_SUBENTRY_KEY_MAP =
      ImmutableMap.of(
          "b2b", Arrays.asList(
              "Taxable amount not determined",
              "Total distribution"
          ));

  public F1099RTaxYear2014() {}

  @Override
  public String getFormType() {
    return "F1099R";
  }

  @Override
  public int getTaxYear() {
    return 2014;
  }

  @Override
  public Map<String, String> getBooleanEntryKeyMap() {
    return BOOLEAN_ENTRY_KEY_MAP;
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
  public String getInputFilePath() {
    return "/forms/input/f1099rtaxyear2014.txt";
  }
}
