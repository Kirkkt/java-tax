package com.kirkkt.java.tax.forms.fillable.federal.worksheets;

import com.kirkkt.java.tax.forms.fillable.AttachedForm;
import com.kirkkt.java.tax.forms.Form;
import com.google.common.collect.ImmutableMap;
import com.kirkkt.java.tax.forms.fillable.federal.F1040ScheduleATaxYear2014;

import java.util.Map;

public class ItemizedDeductionsWorksheetTaxYear2014 extends AttachedForm {

  private static final Map<String, String> INT_ENTRY_KEY_MAP =
      ImmutableMap.<String, String>builder()
          .put("formb2", "")
          .put("formb4", "")
          .put("formb9", "")
          .put("formb14", "")
          .put("formb15", "")
          .put("formb19", "")
          .put("formb20", "")
          .put("formb27", "")
          .put("formb28", "")
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
          .put("bresult", "")
          .build();
  private static final Map<String, String> BOOLEAN_ENTRY_KEY_MAP =
      ImmutableMap.<String, String>builder()
          .put("b3checkbox", "")
          .put("b7checkbox", "")
          .build();

  @Override
  public String getFormType() {
    return "Itemized Deductions Worksheet";
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
  public Map<String, String> getIntEntryKeyMap() {
    return INT_ENTRY_KEY_MAP;
  }

  @Override
  public void readFromMotherForm(Form motherForm) {
    F1040ScheduleATaxYear2014 form = (F1040ScheduleATaxYear2014) motherForm;
    setValue("formb2", form.getIntValue("b2"));
    setValue("formb4", form.getIntValue("b4"));
    setValue("formb9", form.getIntValue("b9"));
    setValue("formb14", form.getIntValue("b14"));
    setValue("formb15", form.getIntValue("b15"));
    setValue("formb19", form.getIntValue("b19"));
    setValue("formb20", form.getIntValue("b20"));
    setValue("formb27", form.getIntValue("b27"));
    setValue("formb28", form.getIntValue("b28"));
    doMath();
  }

  @Override
  public void doMath() {
    setValue("b1", getIntValue("formb4") + getIntValue("formb9") + getIntValue("formb15")
        + getIntValue("formb19") + getIntValue("formb20") + getIntValue("formb27")
        + getIntValue("formb28"));
    setValue("b2", getIntValue("formb4") + getIntValue("formb14") + getIntValue("formb20"));
    setValue("b3checkbox", getIntValue("b2") < getIntValue("b1"));
    setValue("b5", getIntValue("formb2"));

    if (!getBooleanValue("b3checkbox")) {
      resetValue("b5");
      setValue("bresult", getIntValue("b1"));
      return;
    }

    setValue("b3", getIntValue("b1") - getIntValue("b2"));
    setValue("b4", Math.round(.8f * getIntValue("b3")));

    setValue("b6", 254200);
    setValue("b7checkbox", getIntValue("b6") < getIntValue("b5"));
    if (!getBooleanValue("b7checkbox")) {
      setValue("bresult", getIntValue("b1"));
      return;
    }
    setValue("b7", getIntValue("b5") - getIntValue("b6"));
    setValue("b8", Math.round(getIntValue("b7") * .03f));
    setValue("b9", Math.min(getIntValue("b4"), getIntValue("b8")));
    setValue("b10", getIntValue("b1") - getIntValue("b9"));
    setValue("bresult", getIntValue("b10"));
  }
}
