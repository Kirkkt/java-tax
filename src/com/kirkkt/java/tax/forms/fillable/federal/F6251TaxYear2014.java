package com.kirkkt.java.tax.forms.fillable.federal;

import com.google.common.collect.ImmutableMap;
import com.google.common.base.Preconditions;

import com.kirkkt.java.tax.TaxUtil;
import com.kirkkt.java.tax.forms.BooleanEntry;
import com.kirkkt.java.tax.forms.Form;
import com.kirkkt.java.tax.forms.IntEntry;
import com.kirkkt.java.tax.forms.IntListEntry;
import com.kirkkt.java.tax.forms.StringEntry;
import com.kirkkt.java.tax.forms.fillable.federal.worksheets.F6251ExemptionWorksheetTaxYear2014;
import com.kirkkt.java.tax.forms.fillable.federal.worksheets.F1040QualifiedDividendAndCapitalGainTaxWorksheetTaxYear2014;
import com.kirkkt.java.tax.forms.input.InputForm;
import com.kirkkt.java.tax.forms.input.F1099DivTaxYear2014;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class F6251TaxYear2014 extends Form {
  private static final Map<String, String> INT_ENTRY_KEY_MAP =
      ImmutableMap.<String, String>builder()
          .put("f1040b9b", "")
          .put("f1040b10", "")
          .put("f1040b13", "")
          .put("f1040b21", "")
          .put("f1040b38", "")
          .put("f1040b41", "")
          .put("f1040b43", "")
          .put("f1040b44", "")
          .put("f1040b46", "")
          .put("f1040b48", "")
          .put("f1040scheduleab4", "")
          .put("f1040scheduleab9", "")
          .put("f1040scheduleab27", "")
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
          .put("b28", "Alternative minimum taxable income")
          .put("b29", "Exemption")
          .put("b30", "")
          .put("b31", "")
          .put("b32", "")
          .put("b33", "Tentative minimum tax")
          .put("b34", "")
          .put("b35", "AMT")
          .put("b36", "")
          .put("b37", "")
          .put("b38", "")
          .put("b39", "")
          .put("b40", "")
          .put("b41", "")
          .put("b42", "")
          .put("b43", "")
          .put("b44", "")
          .put("b45", "")
          .put("b46", "")
          .put("b47", "")
          .put("b48", "")
          .put("b49", "")
          .put("b50", "")
          .put("b51", "")
          .put("b52", "")
          .put("b53", "")
          .put("b54", "")
          .put("b55", "")
          .put("b56", "")
          .put("b57", "")
          .put("b58", "")
          .put("b59", "")
          .put("b60", "")
          .put("b61", "")
          .put("b62", "")
          .put("b63", "")
          .put("b64", "")
          .build();

  @Override
  public String getFormType() {
    return "F6251";
  }

  @Override
  public int getTaxYear() {
    return 2014;
  }

  @Override
  public Map<String, String> getIntEntryKeyMap() {
    return INT_ENTRY_KEY_MAP;
  }

  public void readFromF1040ScheduleA(F1040ScheduleATaxYear2014 form) {
    // F1040TaxYear2014 form = (F1040TaxYear2014) motherForm;
    // setValue("f1040b38", form.getIntValue("b38"));
    doMath();
  }

  // public void readFromF1040(F1040TaxYear2014 form) {
  //   resetValue("f1099divb1a");
  //   resetValue("f1099divpayername");
  //   setValue("f1099divb1a", form.getIntValue("b1a"));
  //   setValue("f1099divpayername", form.getStringValue("payer name"));
  //   doMath();
  // }

  @Override
  public void doMath() {
    setValue("b1", getIntValue("f1040b41"));
    setValue("b2", Math.min(getIntValue("f1040scheduleab4"),
        Math.round(.025f * getIntValue("f1040b38"))));
    setValue("b3", getIntValue("f1040scheduleab9"));
    setValue("b5", getIntValue("f1040scheduleab27"));

    Preconditions.checkArgument(getIntValue("f1040b38") < 254200,
        TaxUtil.additionalLogicNeededString(this, "6"));

    setValue("b7", -getIntValue("f1040b10") - getIntValue("f1040b21"));
    setValue("b28", getIntValue("b1") + getIntValue("b2") + getIntValue("b3") + getIntValue("b4")
        + getIntValue("b5") + getIntValue("b6") + getIntValue("b7") + getIntValue("b8")
        + getIntValue("b9") + getIntValue("b10") + getIntValue("b11") + getIntValue("b12")
        + getIntValue("b13") + getIntValue("b14") + getIntValue("b15") + getIntValue("b16")
        + getIntValue("b17") + getIntValue("b18") + getIntValue("b19") + getIntValue("b20")
        + getIntValue("b21") + getIntValue("b22") + getIntValue("b23") + getIntValue("b24")
        + getIntValue("b25") + getIntValue("b26") + getIntValue("b27"));

    Preconditions.checkArgument(getIntValue("b28") >= 117300,
        TaxUtil.additionalLogicNeededString(this, "29"));
    {
      F6251ExemptionWorksheetTaxYear2014 worksheet = new F6251ExemptionWorksheetTaxYear2014();
      worksheet.readFromMotherForm(this);
      setValue("b29", worksheet.getIntValue("bresult"));
    }

    setValue("b30", Math.max(0, getIntValue("b28") - getIntValue("b29")));
    Preconditions.checkArgument(getIntValue("b30") > 0,
        TaxUtil.additionalLogicNeededString(this, "30"));

    // dry run part3
    setValue("b36", getIntValue("b30"));
    {
      F1040QualifiedDividendAndCapitalGainTaxWorksheetTaxYear2014 worksheet =
          new F1040QualifiedDividendAndCapitalGainTaxWorksheetTaxYear2014();
      worksheet.setValue("formb9b", getIntValue("f1040b9b"));
      worksheet.setValue("formb13", getIntValue("f1040b13"));
      worksheet.setValue("formb43", getIntValue("f1040b43"));
      worksheet.doMath();

      setValue("b37", worksheet.getIntValue("b6"));
      setValue("b38", worksheet.getIntValue("b5"));
      setValue("b39", getIntValue("b37"));
      setValue("b40", Math.min(getIntValue("b36"), getIntValue("b39")));
      setValue("b41", getIntValue("b36") - getIntValue("b40"));
      if (getIntValue("b41") <= 182500) {
        setValue("b42", Math.round(.26f * getIntValue("b41")));
      } else {
        setValue("b42", Math.round(.28f * getIntValue("b41") - 3650));
      }
      setValue("b43", 36900);
      setValue("b44", worksheet.getIntValue("b7"));
      setValue("b45", Math.max(0, getIntValue("b43") - getIntValue("b44")));
      setValue("b46", Math.min(getIntValue("b36"), getIntValue("b37")));
      setValue("b47", Math.min(getIntValue("b45"), getIntValue("b46")));
      setValue("b48", getIntValue("b46") - getIntValue("b47"));
      setValue("b49", 406750);
      setValue("b50", getIntValue("b45"));
      setValue("b51", worksheet.getIntValue("b7"));
    }

    setValue("b52", getIntValue("b50") + getIntValue("b51"));
    setValue("b53", Math.max(0, getIntValue("b49") - getIntValue("b52")));
    setValue("b54", Math.min(getIntValue("b48"), getIntValue("b53")));
    setValue("b55", Math.round(.15f * getIntValue("b54")));
    setValue("b56", getIntValue("b47") + getIntValue("b54"));
    if (getIntValue("b56") != getIntValue("b36")) {
      setValue("b57", getIntValue("b46") - getIntValue("b56"));
      setValue("b58", Math.round(.2f * getIntValue("b57")));
      if (getIntValue("b38") > 0) {
        setValue("b59", getIntValue("b41") + getIntValue("b56") + getIntValue("b57"));
        setValue("b60", getIntValue("b36") - getIntValue("b59"));
        setValue("b61", Math.round(.25f * getIntValue("b60")));
      }
    }
    setValue("b62", getIntValue("b42") + getIntValue("b55") + getIntValue("b58") + getIntValue("b61"));
    if (getIntValue("b36") <= 182500) {
      setValue("b63", Math.round(.26f * getIntValue("b36")));
    } else {
      setValue("b63", Math.round(.28f * getIntValue("b36") - 3650));
    }
    setValue("b64", Math.min(getIntValue("b62"), getIntValue("b63")));

    // back to part 2
    setValue("b31", getIntValue("b64"));
    setValue("b33", getIntValue("b31") - getIntValue("b32"));
    setValue("b34", getIntValue("f1040b44") + getIntValue("f1040b46") - getIntValue("f1040b48"));
    setValue("b35", Math.max(0, getIntValue("b33") - getIntValue("b34")));
 }
}
