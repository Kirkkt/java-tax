package com.kirkkt.java.tax.forms.input;

import com.google.common.collect.ImmutableMap;

import com.kirkkt.java.tax.Parser;
import com.kirkkt.java.tax.TaxUtil;
import com.kirkkt.java.tax.forms.IntEntry;
import com.kirkkt.java.tax.forms.StringEntry;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class F1099DivTaxYear2014 extends InputForm {

  private static final Map<String, String> STRING_ENTRY_KEY_MAP =
      ImmutableMap.<String, String>builder()
          .put("payer name", "")
          .put("b12", "State")
          .put("b13", "State identification number")
          .build();
  private static final Map<String, String> INT_ENTRY_KEY_MAP =
      ImmutableMap.<String, String>builder()
          .put("b1a", "Total ordinary dividends")
          .put("b1b", "Qualified dividends")
          .put("b2a", "Total capital gain distribution")
          .put("b2b", "Unrecapitalized section 1250 gain")
          .put("b3", "Nondividend distributions")
          .put("b4", "Federal income tax withheld")
          .put("b6", "Foreign tax paid")
          .put("b10", "Exempty-interest dividends")
          .put("b11", "Specified private activity bond interest dividends")
          .put("b14", "State tax withheld")
          .build();
  // TODO(kirktdev): remove?
  private final TaxUtil util = new TaxUtil();

  public F1099DivTaxYear2014() {}

  @Override
  public String getFormType() {
    return "F1099Div";
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
  public String getInputFilePath() {
    return "/forms/input/f1099divtaxyear2014.txt";
  }
}
