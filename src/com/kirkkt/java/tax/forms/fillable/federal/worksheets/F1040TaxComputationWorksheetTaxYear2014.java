package com.kirkkt.java.tax.forms.fillable.federal.worksheets;

import com.kirkkt.java.tax.forms.Form;
import com.kirkkt.java.tax.forms.fillable.AttachedForm;
// import com.kirkkt.java.tax.forms.fillable.federal.F1040TaxYear2014;
// import com.kirkkt.java.tax.forms.fillable.federal.F6251TaxYear2014;
import com.kirkkt.java.tax.TaxUtil;

import com.google.common.collect.ImmutableMap;
import com.google.common.base.Preconditions;

import java.util.Map;

public class F1040TaxComputationWorksheetTaxYear2014 extends AttachedForm {

  private static final Map<String, String> INT_ENTRY_KEY_MAP =
    ImmutableMap.<String, String>builder()
        .put("b1", "")
        .put("bresult", "")
        .build();

  @Override
  public String getFormType() {
    return "F1040 Tax Computation Worksheet";
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
  public void readFromFile(String fileName) {
    super.readFromFile(fileName);
    doMath();
  }

  @Override
  public void readFromMotherForm(Form motherForm) {
    // readFromF1040(form.getB43());
  }

  public void readFromMotherForm(int formB43) {
    setValue("b1", formB43);
  }

  // TODO(kirktdev): extract this to AttachedForm
  private void doMath() {
    int b1 = getIntValue("b1");
    Preconditions.checkArgument(b1 >= 100000, TaxUtil.additionalLogicNeededString(this));
    Preconditions.checkArgument(b1 <= 405100, TaxUtil.additionalLogicNeededString(this));

    if (b1 <= 186350) {
      setValue("bResult", Math.round(b1 * .28f - 6824.25f));
    } else if (b1 <= 405100) {
      setValue("bResult", Math.round(b1 * .33f - 16141.75f));
    }
  }
}
