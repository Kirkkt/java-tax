package com.kirkkt.java.tax.forms.fillable.federal.worksheets;

import com.kirkkt.java.tax.forms.fillable.AttachedForm;
import com.kirkkt.java.tax.forms.Form;
// import com.kirkkt.java.tax.forms.fillable.federal.F1040TaxYear2014;
// import com.kirkkt.java.tax.forms.fillable.federal.F6251TaxYear2014;
import com.kirkkt.java.tax.TaxUtil;

import com.google.common.collect.ImmutableMap;
import com.google.common.base.Preconditions;

import java.util.Map;

public class F1040QualifiedDividendAndCapitalGainTaxWorksheetTaxYear2014 extends AttachedForm {

  private static final Map<String, String> INT_ENTRY_KEY_MAP =
      ImmutableMap.<String, String>builder()
          .put("b1", "")
          .put("b2", "")
          .put("b3", "")
          .put("b4", "")
          .put("b5", "")
          .put("b6", "")
          .put("b7", "")
          .put("b8", "")
          .put("b9", "")
          .put("b10", "")
          .put("b11", "")
          .put("b12", "")
          .put("b13", "")
          .put("b14", "")
          .put("b15", "")
          .put("b16", "")
          .put("b17", "")
          .put("b18", "")
          .put("b19", "")
          .put("b20", "")
          .put("b21", "")
          .put("b22", "")
          .put("b23", "")
          .put("b24", "")
          .put("b25", "")
          .put("b26", "")
          .put("b27", "")
          .put("bresult", "")
          .build();

  @Override
  public String getFormType() {
    return "F1040 Qualified Dividend And Capital Gain Tax Worksheet";
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
  public void readFromMotherForm(Form form) {
  // public void readFromMotherForm(F1040TaxYear2014 form) {
    // readFromF1040(
    //     form.getB9b(),
    //     form.getB13(),
    //     form.getB43()
    // );
  }

  public void readFromMotherForm(
      int formB9b,
      int formB13,
      int formB43
  ) {
    setValue("b1", formB43);
    setValue("b2", formB9b);
    setValue("b3", formB13);
    doMath();
  }

  private void doMath() {
    setValue("b4", getIntValue("b2") + getIntValue("b3"));
    setValue("b5", 0);
    setValue("b6", Math.max(0, getIntValue("b4") - getIntValue("b5")));
    setValue("b7", Math.max(0, getIntValue("b1") - getIntValue("b6")));
    setValue("b8", 36250);
    setValue("b9", Math.min(getIntValue("b1"), getIntValue("b8")));
    setValue("b10", Math.min(getIntValue("b7"), getIntValue("b9")));
    setValue("b11", getIntValue("b9") - getIntValue("b10"));
    setValue("b12", Math.min(getIntValue("b1"), getIntValue("b6")));
    setValue("b13", getIntValue("b11"));
    setValue("b14", getIntValue("b12") - getIntValue("b13"));
    setValue("b15", 400000);
    setValue("b16", Math.min(getIntValue("b1"), getIntValue("b15")));
    setValue("b17", getIntValue("b7") + getIntValue("b11"));
    setValue("b18", Math.max(0, getIntValue("b16") - getIntValue("b17")));
    setValue("b19", Math.min(getIntValue("b14"), getIntValue("b18")));
    setValue("b20", Math.round(.15f * getIntValue("b19")));
    setValue("b21", getIntValue("b11") + getIntValue("b19"));
    setValue("b22", getIntValue("b12") - getIntValue("b21"));
    setValue("b23", Math.round(.2f * getIntValue("b22")));

    F1040TaxComputationWorksheetTaxYear2014 worksheet;
    Preconditions.checkArgument(getIntValue("b7") >= 100000, TaxUtil.additionalLogicNeededString(this, "24"));
    worksheet = new F1040TaxComputationWorksheetTaxYear2014();
    worksheet.readFromMotherForm(getIntValue("b7"));
    setValue("b24", worksheet.getIntValue("bresult"));
    setValue("b25", getIntValue("b20") + getIntValue("b23") + getIntValue("b24"));
    Preconditions.checkArgument(getIntValue("b1") >= 100000, TaxUtil.additionalLogicNeededString(this, "26"));
    worksheet = new F1040TaxComputationWorksheetTaxYear2014();
    worksheet.readFromMotherForm(getIntValue("b1"));
    setValue("b26", worksheet.getIntValue("bresult"));
    setValue("b27", Math.min(getIntValue("b25"), getIntValue("b26")));
    setValue("bresult", getIntValue("b27"));
  }
}
