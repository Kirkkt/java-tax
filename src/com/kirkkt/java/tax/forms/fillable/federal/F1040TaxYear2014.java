package com.kirkkt.java.tax.forms.fillable.federal;

import com.kirkkt.java.tax.TaxUtil;
import com.kirkkt.java.tax.forms.BooleanEntry;
import com.kirkkt.java.tax.forms.Form;
import com.kirkkt.java.tax.forms.IntEntry;
import com.kirkkt.java.tax.forms.IntListEntry;
import com.kirkkt.java.tax.forms.StringEntry;
import com.kirkkt.java.tax.forms.fillable.federal.worksheets.F1040QualifiedDividendAndCapitalGainTaxWorksheetTaxYear2014;
import com.kirkkt.java.tax.forms.fillable.federal.worksheets.F1040TaxComputationWorksheetTaxYear2014;
import com.kirkkt.java.tax.forms.input.F1099DivTaxYear2014;
import com.kirkkt.java.tax.forms.input.F1099GTaxYear2014;
import com.kirkkt.java.tax.forms.input.F1099RTaxYear2014;
import com.kirkkt.java.tax.forms.input.InputForm;
import com.kirkkt.java.tax.forms.input.W2TaxYear2014;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class F1040TaxYear2014 extends Form {

  private static final Map<String, String> BOOLEAN_ENTRY_KEY_MAP =
      ImmutableMap.<String, String>builder()
          .put("b1", "Single")
          .put("b2", "Married filing jointly")
          .put("b3", "Married filing separately")
          .put("b4", "Head of household")
          .put("b5", "Qualifying widow(er) with dependent child")
          .put("b6a", "Yourself")
          .put("b6b", "Spouse")
          .put("b13checkbox", "Capital gain or loss")
          .put("b44a", "")
          .put("b44b", "")
          .put("b44c", "")
          .put("b54a", "")
          .put("b54b", "")
          .put("b54c", "")
          .put("b58a", "")
          .put("b58b", "")
          .put("b61checkbox", "")
          .put("b62a", "")
          .put("b62b", "")
          .put("b62c", "")
          .put("b73a", "")
          .put("b73d", "")
          .put("b39b", "")
          .put("b76checkbox", "")
          // TODO(kirktdev): mustprint this
          .put("ballowthirdpartyassignee", "")
          .build();

  private static final Map<String, String> INT_ENTRY_KEY_MAP =
      ImmutableMap.<String, String>builder()
          .put("f1099divb1a", "")
          .put("f1099divb1b", "")
          .put("f1099divb2a", "")
          .put("f1099divb4", "")
          .put("f1099gb2", "")
          .put("f1099rb1", "")
          .put("f1099rb2a", "")
          .put("f1099rb3", "")
          .put("f1099rb4", "")
          .put("w2b1", "")
          .put("w2b2", "")
          .put("w2b17", "")
          .put("b6d", "")
          .put("b7", "")
          .put("b8a", "Taxable interest")
          .put("b8b", "Tax-exempt interest")
          .put("b9a", "Ordinary dividends")
          .put("b9b", "Qaulified dividends")
          .put("b10", "Taxable state tax refunds")
          .put("b11", "")
          .put("b12", "")
          .put("b13", "Capital gain")
          .put("b14", "")
          .put("b15a", "")
          .put("b15b", "")
          .put("b16a", "Pensions and annuities")
          .put("b16b", "Taxable amount")
          .put("b17", "")
          .put("b18", "")
          .put("b19", "")
          .put("b20a", "")
          .put("b20b", "")
          .put("b21", "")
          .put("b22", "Total income")
          .put("b23", "")
          .put("b24", "")
          .put("b25", "")
          .put("b26", "")
          .put("b27", "")
          .put("b28", "")
          .put("b29", "")
          .put("b30", "")
          .put("b31a", "")
          .put("b32", "")
          .put("b33", "")
          .put("b34", "")
          .put("b35", "")
          .put("b36", "")
          .put("b37", "Adjusted gross income")
          .put("b38", "")
          .put("b39a", "")
          .put("b40", "Deductions")
          .put("b41", "")
          .put("b42", "Exemptions")
          .put("b43", "Taxable income")
          .put("b44", "Tax")
          .put("b45", "Alternative minimal tax")
          .put("b46", "")
          .put("b47", "")
          .put("b48", "")
          .put("b49", "")
          .put("b50", "")
          .put("b51", "")
          .put("b52", "")
          .put("b53", "")
          .put("b54", "")
          .put("b55", "Total credits")
          .put("b56", "")
          .put("b57", "")
          .put("b58", "")
          .put("b59", "")
          .put("b60a", "")
          .put("b60b", "")
          .put("b61", "")
          .put("b62", "")
          .put("b63", "Total tax")
          .put("b64", "")
          .put("b65", "")
          .put("b66a", "")
          .put("b66b", "")
          .put("b67", "")
          .put("b68", "")
          .put("b69", "")
          .put("b70", "")
          .put("b71", "")
          .put("b72", "")
          .put("b73", "")
          .put("b74", "Total payments")
          .put("b75", "Amount you overpaid")
          .put("b76a", "")
          .put("b77", "")
          .put("b78", "Amount you owe")
          .put("b79", "")
          .build();

  private static final Map<String, String> STRING_ENTRY_KEY_MAP =
      ImmutableMap.<String, String>builder()
          .put("routing number", "")
          .put("account type", "")
          .put("account number", "")
          .put("b6c", "")
          .put("b31b", "")
          .put("b44cInput", "")
          .put("b54cInput", "")
          .put("b62cInput", "")
          .put("b73dInput", "")
          .put("b76b", "")
          .put("b76c", "")
          .put("b76d", "")
          .build();

  private static final Map<String, String> BOOLEAN_LIST_ENTRY_KEY_MAP =
      ImmutableMap.<String, String>builder()
          .put("b39acheckboxes", "")
          .build();

  private static final Map<String, List<String>> BOOLEAN_LIST_SUBENTRY_KEY_MAP =
      ImmutableMap.of(
          "b39acheckboxes", Arrays.asList(
              "You are born before 1950",
              "Your spouse is born before 1950",
              "You are blind",
              "Your spouse is blind"
          ));

  @Override
  public String getFormType() {
    return "F1040";
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
  public Map<String, String> getBooleanListEntryKeyMap() {
    return BOOLEAN_LIST_ENTRY_KEY_MAP;
  }

  @Override
  public Map<String, List<String>> getBooleanListSubentryKeyMap() {
    return BOOLEAN_LIST_SUBENTRY_KEY_MAP;
  }

  public void readFromF1099Div(F1099DivTaxYear2014 form) {
    setValue("f1099divb1a", form.getIntValue("b1a"));
    setValue("f1099divb1b", form.getIntValue("b1b"));
    setValue("f1099divb2a", form.getIntValue("b2a"));
    setValue("f1099divb4", form.getIntValue("b4"));
    doMath();
    setValue("f1099divb1a", 0);
    setValue("f1099divb1b", 0);
    setValue("f1099divb2a", 0);
    setValue("f1099divb4", 0);
  }

  public void readFromF1099G(F1099GTaxYear2014 form) {
    setValue("f1099gb2", form.getIntValue("b2"));
    doMath();
    setValue("f1099gb2", 0);
  }

  public void readFromF1099R(F1099RTaxYear2014 form) {
    setValue("f1099rb1", form.getIntValue("b1"));
    setValue("f1099rb2a", form.getIntValue("b2a"));
    setValue("f1099rb3", form.getIntValue("b3"));
    setValue("f1099rb4", form.getIntValue("b4"));
    doMath();
    setValue("f1099rb1", 0);
    setValue("f1099rb2a", 0);
    setValue("f1099rb3", 0);
    setValue("f1099rb4", 0);
  }

  public void readFromW2(W2TaxYear2014 form) {
    setValue("w2b1", form.getIntValue("b1"));
    setValue("w2b2", form.getIntValue("b2"));
    setValue("w2b17", form.getIntValue("b17"));
    doMath();
  }

  @Override
  public void doMath() {
    setValue("b6d", 0);
    if (getBooleanValue("b6a")) {
      setValue("b6d", getIntValue("b6d") + 1);
    }
    if (getBooleanValue("b6b")) {
      setValue("b6d", getIntValue("b6d") + 1);
    }
    setValue("b7", getIntValue("w2b1"));
    setValue("b9a", getIntValue("b9a") + getIntValue("f1099divb1a"));
    setValue("b9b", getIntValue("b9b") + getIntValue("f1099divb1b"));
    setValue("b10", getIntValue("b10") + getIntValue("f1099gb2"));
    setValue("b13", getIntValue("b13") + getIntValue("f1099divb2a"));
    setValue("b16a", getIntValue("b16a") + getIntValue("f1099rb1"));
    setValue("b16b", getIntValue("b16b") + getIntValue("f1099rb2a"));
    setValue("b22", getIntValue("b7") + getIntValue("b8a") + getIntValue("b9a")
        + getIntValue("b10") + getIntValue("b13") + getIntValue("b16b"));
    setValue("b36", getIntValue("b23") + getIntValue("b24") + getIntValue("b25")
        + getIntValue("b26") + getIntValue("b27") + getIntValue("b28") + getIntValue("b29")
        + getIntValue("b30") + getIntValue("b31a") + getIntValue("b32") + getIntValue("b33")
        + getIntValue("b34") + getIntValue("b35") + getIntValue("b36"));
    setValue("b37", getIntValue("b22") - getIntValue("b36"));
    setValue("b38", getIntValue("b37"));
    {
      int count = 0;
      List<?> list = (List<?>) getValue("b39acheckboxes");
      if (list != null && !list.isEmpty()) {
        for (Object item : list) {
          if (((BooleanEntry) item).getValue()) {
            count++;
          }
        }
      }
      setValue("b39a", count);
    }

    {
      F1040ScheduleATaxYear2014 f1040ScheduleA = new F1040ScheduleATaxYear2014();
      f1040ScheduleA.readFromMotherForm(this);
      setValue("b40", Math.max(6200, f1040ScheduleA.getIntValue("b29")));
    }

    setValue("b41", getIntValue("b38") - getIntValue("b40"));
    Preconditions.checkState(getIntValue("b38") < 254200,
        TaxUtil.additionalLogicNeededString(this, "42"));

    Preconditions.checkState(getIntValue("b38") < 254200,
        TaxUtil.additionalLogicNeededString(this, "42"));
    setValue("b42", 3950);

    setValue("b43", Math.max(getIntValue("b41") - getIntValue("b42"), 0));

    {
      F1040TaxComputationWorksheetTaxYear2014 worksheet
          = new F1040TaxComputationWorksheetTaxYear2014();
      worksheet.readFromMotherForm(this);
      setValue("b44", worksheet.getIntValue("bresult"));
    }

    {
      F6251TaxYear2014 form = new F6251TaxYear2014();
      form.readFromMotherForm(this);
      setValue("b45", form.getIntValue("b35"));
    }

    setValue("b47", getIntValue("b44") + getIntValue("b45") + getIntValue("b46"));

    setValue("b55", getIntValue("b48") + getIntValue("b49") + getIntValue("b50")
        + getIntValue("b51") + getIntValue("b52") + getIntValue("b53") + getIntValue("b54"));
    setValue("b56", Math.max(getIntValue("b47") - getIntValue("b55"), 0));

    setValue("b63", getIntValue("b56") + getIntValue("b57") + getIntValue("b58")
        + getIntValue("b59") + getIntValue("b60a") + getIntValue("b60b") + getIntValue("b61")
        + getIntValue("b62"));
    setValue("b64", getIntValue("w2b2"));

    setValue("b74", getIntValue("b64") + getIntValue("b65") + getIntValue("b66a")
        + getIntValue("b67") + getIntValue("b68") + getIntValue("b69") + getIntValue("b70")
        + getIntValue("b71") + getIntValue("b72") + getIntValue("b73"));

    setValue("b75", Math.max(getIntValue("b74") - getIntValue("b63"), 0));
    if (getIntValue("b75") > 0) {
      setValue("b76a", getIntValue("b75"));
      setValue("b76b", getStringValue("routing number"));
      setValue("b76c", getStringValue("account type"));
      setValue("b76d", getStringValue("account number"));
    }
    setValue("b78", Math.max(getIntValue("b63") - getIntValue("b74"), 0));
  }
}
