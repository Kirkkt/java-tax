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
import com.kirkkt.java.tax.forms.input.W2TaxYear2014;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class F1040ScheduleATaxYear2014 extends Form {
  private static final Map<String, String> STRING_ENTRY_KEY_MAP =
      ImmutableMap.<String, String>builder()
          .put("b5checkbox", "A value between [Income taxes] and [General sales taxes]")
          .build();
  private static final Map<String, String> INT_ENTRY_KEY_MAP =
      ImmutableMap.<String, String>builder()
          .put("formb38", "")
          .put("w2b17", "")
          .put("b1", "Medical and dental expenses")
          .put("b2", "Form 1040 line 38")
          .put("b3", "10% of line 2")
          .put("b4", "3 - 1")
          .put("b5", "State and local tax paid")
          .put("b6", "Real estate taxes")
          .put("b7", "Personal property taxes")
          .put("b8", "Other taxes amount")
          .put("b9", "5+...+9")
          .put("b10", "Home morgage interest and points")
          .put("b11", "Unreported home morgage interest payee amount")
          .put("b12", "Unreported home morgage points")
          .put("b13", "Morgage insurance premiums")
          .put("b14", "Investment interest")
          .put("b15", "10+...+14")
          .put("b16", "Gifts to charity by cash or check")
          .put("b17", "Gifts to charity other than by cash or check")
          .put("b18", "Gifts to charity carryover from prior year")
          .put("b19", "16+..+18")
          .put("b20", "Casualty or theft loss")
          .put("b21", "Unreimbursed employee expenses amount")
          .put("b22", "Tax preparation fees")
          .put("b23", "Other expenses amount")
          .put("b24", "21+...+23")
          .put("b25", "Form 1040 line 38")
          .put("b26", "2% of 25")
          .put("b27", "26-24")
          .put("b28", "Other amount")
          .put("b29", "Total itemized deductions")
          .build();
  private static final Map<String, String> BOOLEAN_ENTRY_KEY_MAP =
      ImmutableMap.<String, String>builder()
          .put("b29checkbox", "Form 1040 line 28 > 152535?")
          .put("b30", "Force itemized deductions")
          .build();
  private static final Map<String, String> INT_LIST_ENTRY_KEY_MAP =
      ImmutableMap.<String, String>builder()
          .put("b8list", "Other taxes list")
          .put("b11list", "Unreported home morgage interest payee info")
          .put("b21list", "Unreimbursed employee expenses list")
          .put("b23list", "Other expenses list")
          .put("b28list", "Other list")
          .build();

  @Override
  public String getFormType() {
    return "F1040 Schedule A";
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
    F1040TaxYear2014 form = (F1040TaxYear2014) motherForm;
    setValue("formb38", form.getIntValue("b38"));
    setValue("w2b17", form.getIntValue("w2b17"));
    doMath();
  }

  public void readFromW2(W2TaxYear2014 form) {
    setValue("w2b17", form.getIntValue("b17"));
    doMath();
  }

  @Override
  public void doMath() {
    setValue("b2", getIntValue("formb38"));
    setValue("b25", getIntValue("formb38"));
    setValue("b29checkbox", getIntValue("formb38") > 152525);
    setValue("b5", getIntValue("w2b17"));
    if (getSumValue("b8list") > 0) {
      setValue("b8", getSumValue("b8list"));
    }
    if (getSumValue("b11list") > 0) {
      setValue("b11", getSumValue("b11list"));
    }
    if (getSumValue("b21list") > 0) {
      setValue("b21", getSumValue("b21list"));
    }
    if (getSumValue("b23list") > 0) {
      setValue("b23", getSumValue("b23list"));
    }
    if (getSumValue("b28list") > 0) {
      setValue("b28", getSumValue("b28list"));
    }

    if (getIntValue("b2") > 0) {
      setValue("b3", Math.round(.1f * getIntValue("b2")));
    }
    if (getIntValue("b1") > getIntValue("b3")) {
      setValue("b4", Math.max(0, getIntValue("b1") - getIntValue("b3")));
    }

    setValue("b9", getIntValue("b5") + getIntValue("b6") + getIntValue("b7") + getIntValue("b8"));

    setValue("b15", getIntValue("b10") + getIntValue("b11") + getIntValue("b12")
        + getIntValue("b13") + getIntValue("b14"));

    setValue("b19", getIntValue("b16") + getIntValue("b17") + getIntValue("b18"));

    setValue("b24", getIntValue("b21") + getIntValue("b22") + getIntValue("b23"));
    if (getIntValue("b25") > 0) {
      setValue("b26", Math.round(.02f * getIntValue("b25")));
    }
    setValue("b27", Math.max(getIntValue("b24") - getIntValue("b26"), 0));

    if (!getBooleanValue("b29checkbox")) {
      setValue("b29", getIntValue("b4") + getIntValue("b9") + getIntValue("b15")
          + getIntValue("b19") + getIntValue("b20") + getIntValue("b27") + getIntValue("b28"));
    } else {
      ItemizedDeductionsWorksheetTaxYear2014 worksheet =
          new ItemizedDeductionsWorksheetTaxYear2014();
      worksheet.readFromMotherForm(this);
      setValue("b29", worksheet.getIntValue("bresult"));
    }
  }

}
