package com.kirkkt.java.tax.forms.fillable.federal;

import com.google.common.collect.ImmutableMap;

import com.kirkkt.java.tax.TaxUtil;
import com.kirkkt.java.tax.forms.BooleanEntry;
import com.kirkkt.java.tax.forms.Form;
import com.kirkkt.java.tax.forms.IntEntry;
import com.kirkkt.java.tax.forms.IntListEntry;
import com.kirkkt.java.tax.forms.StringEntry;
import com.kirkkt.java.tax.forms.fillable.federal.worksheets.ItemizedDeductionsWorksheetTaxYear2014;
import com.kirkkt.java.tax.forms.input.InputForm;
import com.kirkkt.java.tax.forms.input.F1099DivTaxYear2014;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class F1040ScheduleBTaxYear2014 extends Form {
  private static final Map<String, String> STRING_ENTRY_KEY_MAP =
      ImmutableMap.<String, String>builder()
          .put("f1099divpayername", "")
          .put("b7b", "Name of foreign country for financial account")
          .build();
  private static final Map<String, String> INT_ENTRY_KEY_MAP =
      ImmutableMap.<String, String>builder()
          .put("f1099divb1a", "")
          .put("b2", "")
          .put("b3", "")
          .put("b4", "")
          .put("b6", "")
          .build();
  private static final Map<String, String> BOOLEAN_ENTRY_KEY_MAP =
      ImmutableMap.<String, String>builder()
          .put("b7a", "Foreign account")
          .put("b8", "Foreign trust")
          .build();
  private static final Map<String, String> INT_LIST_ENTRY_KEY_MAP =
      ImmutableMap.<String, String>builder()
          .put("b1", "List name of interest payers")
          .put("b5", "List name of ordinary dividends payers")
          .build();

  @Override
  public String getFormType() {
    return "F1040 Schedule B";
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
  public Map<String, String> getBooleanEntryKeyMap() {
    return BOOLEAN_ENTRY_KEY_MAP;
  }

  @Override
  public Map<String, String> getIntListEntryKeyMap() {
    return INT_LIST_ENTRY_KEY_MAP;
  }

  public void readFromMotherForm(Form motherForm) {
    // F1040TaxYear2014 form = (F1040TaxYear2014) motherForm;
    // setValue("formb38", form.getIntValue("formb38"));
    doMath();
  }

  public void readFromF1099Div(F1099DivTaxYear2014 form) {
    resetValue("f1099divb1a");
    resetValue("f1099divpayername");
    setValue("f1099divb1a", form.getIntValue("b1a"));
    setValue("f1099divpayername", form.getStringValue("payer name"));
    doMath();
  }

  @Override
  public void doMath() {
    IntEntry entry = new IntEntry();
    entry.setValue(getIntValue("f1099divb1a"));
    entry.setDescription(getStringValue("f1099divpayername"));
    addValue("b5", entry);

    setValue("b2", getSumValue("b1"));
    setValue("b4", getIntValue("b2") - getIntValue("b3"));
    if (getIntValue("b4") > 1500) {
      forceSetValue("b7a", getBooleanValue("b7a"));
      forceSetValue("b8", getBooleanValue("b8"));
    }
    setValue("b6", getSumValue("b5"));
  }

}
