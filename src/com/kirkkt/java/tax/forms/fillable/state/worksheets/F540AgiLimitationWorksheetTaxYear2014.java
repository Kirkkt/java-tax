package com.kirkkt.java.tax.forms.fillable.state.worksheets;

import com.kirkkt.java.tax.TaxUtil;
import com.kirkkt.java.tax.forms.Form;
import com.kirkkt.java.tax.forms.fillable.state.F540TaxYear2014;

import com.google.common.collect.ImmutableMap;
import com.google.common.base.Preconditions;

import java.util.Map;

public class F540AgiLimitationWorksheetTaxYear2014 extends Form {
  private static final Map<String, String> INT_ENTRY_KEY_MAP =
      ImmutableMap.<String, String>builder()
          .put("formb7", "")
          .put("formb7dollarvalue", "")
          .put("formb8", "")
          .put("formb8dollarvalue", "")
          .put("formb9", "")
          .put("formb9dollarvalue", "")
          .put("formb10", "")
          .put("formb10dollarvalue", "")
          .put("formb13", "")
          .put("ba", "")
          .put("bb", "")
          .put("bc", "")
          .put("bd", "")
          .put("be", "")
          .put("bf", "")
          .put("bg", "")
          .put("bh", "")
          .put("bi", "")
          .put("bj", "")
          .put("bk", "")
          .put("bl", "")
          .put("bm", "")
          .put("bn", "")
          .put("bresult", "")
          .build();

  private static final Map<String, String> BOOLEAN_ENTRY_KEY_MAP =
      ImmutableMap.<String, String>builder()
          .put("formb1", "")
          .build();

  @Override
  public String getFormType() {
    return "F540 Agi Limitation Worksheet";
  }

  @Override
  public int getTaxYear() {
    return 2014;
  }

  @Override
  public Map<String, String> getIntEntryKeyMap() {
    return INT_ENTRY_KEY_MAP;
  }

  @Override
  public Map<String, String> getBooleanEntryKeyMap() {
    return BOOLEAN_ENTRY_KEY_MAP;
  }

  public void readFromMotherForm(F540TaxYear2014 form) {
    setValue("formb1", form.getBooleanValue("b1"));
    setValue("formb7", form.getIntValue("b7"));
    setValue("formb7dollarvalue", form.getIntValue("b7dollarvalue"));
    setValue("formb8", form.getIntValue("b8"));
    setValue("formb8dollarvalue", form.getIntValue("b8dollarvalue"));
    setValue("formb9", form.getIntValue("b9"));
    setValue("formb9dollarvalue", form.getIntValue("b9dollarvalue"));
    setValue("formb10", form.getIntValue("b10"));
    setValue("formb10dollarvalue", form.getIntValue("b10dollarvalue"));
    setValue("formb13", form.getIntValue("b13"));
    doMath();
  }

  @Override
  public void doMath() {
    Preconditions.checkState(getBooleanValue("formb1"),
        TaxUtil.additionalLogicNeededString(this, "a"));

    setValue("ba", getIntValue("formb13"));
    setValue("bb", 176413);
    setValue("bc", getIntValue("ba") - getIntValue("bb"));
    setValue("bd", (getIntValue("bc") / 2500) + 1);
    setValue("be", getIntValue("bd") * 6);
    setValue("bf", getIntValue("formb7") + getIntValue("formb8") + getIntValue("formb9"));
    setValue("bg", getIntValue("bf") * getIntValue("be"));
    setValue("bh", getIntValue("formb7dollarvalue") + getIntValue("formb8dollarvalue")
        + getIntValue("formb9dollarvalue"));
    setValue("bi", Math.max(0, getIntValue("bh") - getIntValue("bg")));
    setValue("bj", getIntValue("formb10"));
    setValue("bk", getIntValue("be") * getIntValue("bj"));
    setValue("bl", getIntValue("formb10dollarvalue"));
    setValue("bm", Math.max(0, getIntValue("bl") - getIntValue("bk")));
    setValue("bn", getIntValue("bi") + getIntValue("bm"));
    setValue("bresult", getIntValue("bn"));
  }
}
