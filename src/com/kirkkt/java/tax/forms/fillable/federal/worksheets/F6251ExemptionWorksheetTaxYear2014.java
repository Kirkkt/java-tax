package com.kirkkt.java.tax.forms.fillable.federal.worksheets;

import com.kirkkt.java.tax.TaxUtil;
import com.kirkkt.java.tax.forms.Form;
// import com.kirkkt.java.tax.forms.fillable.federal.F6251TaxYear2014;

import com.google.common.collect.ImmutableMap;
import com.google.common.base.Preconditions;

import java.util.Map;

public class F6251ExemptionWorksheetTaxYear2014 extends Form {

  private static final Map<String, String> INT_ENTRY_KEY_MAP =
      ImmutableMap.<String, String>builder()
          .put("formb28", "")
          .put("b1", "")
          .put("b2", "")
          .put("b3", "")
          .put("b4", "")
          .put("b5", "")
          .put("b6", "")
          .put("bresult", "")
          .build();

  @Override
  public String getFormType() {
    return "F6251 Exemption Worksheet";
  }

  @Override
  public int getTaxYear() {
    return 2014;
  }

  @Override
  public Map<String, String> getIntEntryKeyMap() {
    return INT_ENTRY_KEY_MAP;
  }

  public void readFromMotherForm(Form form) {
    // readFromF6251(form.getB28());
  }

  @Override
  public void doMath() {
    if (getIntValue("formb28") >= 328500) {
      setValue("bresult", getIntValue("formb28"));
      return;
    }

    setValue("b1", 52800);
    setValue("b2", getIntValue("formb28"));
    setValue("b3", 117300);
    setValue("b4", Math.max(0, getIntValue("b2") - getIntValue("b3")));
    setValue("b5", Math.round(.25f * getIntValue("b4")));
    setValue("b6", Math.max(0, getIntValue("b1") - getIntValue("b5")));
    setValue("bresult", getIntValue("b6"));
  }
}
