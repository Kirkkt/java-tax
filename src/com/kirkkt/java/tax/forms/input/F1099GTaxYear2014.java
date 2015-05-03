package com.kirkkt.java.tax.forms.input;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;

import com.kirkkt.java.tax.Parser;
import com.kirkkt.java.tax.forms.IntEntry;
import com.kirkkt.java.tax.forms.StringEntry;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class F1099GTaxYear2014 extends InputForm {

  private static final Map<String, String> STRING_ENTRY_KEY_MAP =
      ImmutableMap.<String, String>builder()
          .put("payer info", "")
          .put("payer fein", "")
          .build();
  private static final Map<String, String> INT_ENTRY_KEY_MAP =
      ImmutableMap.<String, String>builder()
          .put("b2", "State or local income tax refunds, credits, or offsets")
          .put("b3", "Tax year")
          .build();

  public F1099GTaxYear2014() {}

  @Override
  public String getFormType() {
    return "F1099G";
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
    return "/forms/input/f1099gtaxyear2014.txt";
  }
}
