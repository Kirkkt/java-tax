package com.kirkkt.java.tax.forms.fillable.state;

import com.kirkkt.java.tax.TaxUtil;
import com.kirkkt.java.tax.forms.BooleanEntry;
import com.kirkkt.java.tax.forms.Form;
import com.kirkkt.java.tax.forms.IntEntry;
import com.kirkkt.java.tax.forms.IntListEntry;
import com.kirkkt.java.tax.forms.StringEntry;
import com.kirkkt.java.tax.forms.fillable.federal.F1040TaxYear2014;
import com.kirkkt.java.tax.forms.fillable.state.worksheets.F540AgiLimitationWorksheetTaxYear2014;
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

public class F540TaxYear2014 extends Form {

  private static final Map<String, String> BOOLEAN_ENTRY_KEY_MAP =
      ImmutableMap.<String, String>builder()
          .put("b1", "Single")
          .put("b2", "Married filing jointly")
          .put("b3", "Married filing separately")
          .put("b4", "Head of household")
          .put("b5", "Qualifying widow(er) with dependent child")
          .put("ballowthirdpartyassignee", "")
          .build();

  private static final Map<String, String> INT_ENTRY_KEY_MAP =
      ImmutableMap.<String, String>builder()
          .put("f1040b37", "")
          .put("f540schedulecab37b", "")
          .put("f540schedulecab37c", "")
          .put("f540schedulecab44", "")
          .put("w2b16", "")
          .put("w2b17", "")
          .put("b7", "")
          .put("b7dollarvalue", "")
          .put("b8", "")
          .put("b8dollarvalue", "")
          .put("b9", "")
          .put("b9dollarvalue", "")
          .put("b10", "")
          .put("b10dollarvalue", "")
          .put("b11", "Exemption amount")
          .put("b12", "")
          .put("b13", "")
          .put("b14", "")
          .put("b15", "")
          .put("b16", "")
          .put("b17", "")
          .put("b18", "")
          .put("b19", "Taxable income")
          .put("b31", "Tax")
          .put("b32", "")
          .put("b33", "")
          .put("b34", "")
          .put("b35", "")
          .put("b40", "")
          .put("b43", "")
          .put("b44", "")
          .put("b45", "")
          .put("b46", "")
          .put("b47", "")
          .put("b48", "")
          .put("b61", "")
          .put("b62", "")
          .put("b63", "")
          .put("b64", "")
          .put("b71", "")
          .put("b72", "")
          .put("b73", "")
          .put("b74", "")
          .put("b75", "")
          .put("b91", "")
          .put("b92", "")
          .put("b93", "")
          .put("b94", "")
          .put("b95", "")
          .put("b110", "")
          .put("b111", "")
          .put("b112", "")
          .put("b113", "")
          .put("b114", "")
          .put("b115", "")
          .put("b116", "")
          .put("b117", "")
          .put("b400", "")
          .put("b401", "")
          .put("b403", "")
          .put("b405", "")
          .put("b406", "")
          .put("b407", "")
          .put("b408", "")
          .put("b410", "")
          .put("b413", "")
          .put("b419", "")
          .put("b422", "")
          .put("b423", "")
          .put("b424", "")
          .put("b425", "")
          .put("b426", "")
          .put("b427", "")
          .put("b428", "")
          .put("b429", "")
          .build();

  private static final Map<String, String> STRING_ENTRY_KEY_MAP =
      ImmutableMap.<String, String>builder()
          .put("routing number", "")
          .put("account type", "")
          .put("account number", "")
          .put("b31checkbox", "")
          .build();

  private static final Map<String, String> BOOLEAN_LIST_ENTRY_KEY_MAP =
      ImmutableMap.<String, String>builder()
          // .put("b39acheckboxes", "")
          .build();

  private static final Map<String, List<String>> BOOLEAN_LIST_SUBENTRY_KEY_MAP =
      ImmutableMap.of(
          // "b39acheckboxes", Arrays.asList(
          //     "You are born before 1950",
          //     "Your spouse is born before 1950",
          //     "You are blind",
          //     "Your spouse is blind")
          );

  public F540TaxYear2014() {
    forceSetValue("ballowthirdpartyassignee", false);
  }

  @Override
  public String getFormType() {
    return "F540";
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

  public void readFromF1040(F1040TaxYear2014 form) {
    setValue("f1040b37", form.getIntValue("b37"));
    doMath();
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

  public void readFromF540ScheduleCa(F540ScheduleCaTaxYear2014 form) {
    setValue("f540schedulecab37b", form.getIntValue("b37b"));
    doMath();
  }

  public void readFromW2(W2TaxYear2014 form) {
    setValue("w2b16", form.getIntValue("b16"));
    setValue("w2b17", form.getIntValue("b17"));
    doMath();
  }

  @Override
  public void doMath() {
    if (getBooleanValue("b1") || getBooleanValue("b3") || getBooleanValue("b4")) {
      setValue("b7", 1);
    }
    setValue("b7dollarvalue", getIntValue("b7") * 108);
    setValue("b8dollarvalue", getIntValue("b8") * 108);
    setValue("b9dollarvalue", getIntValue("b9") * 108);
    setValue("b10dollarvalue", getIntValue("b10") * 333);
    setValue("b11", getIntValue("b7dollarvalue") + getIntValue("b8dollarvalue")
        + getIntValue("b9dollarvalue") + getIntValue("b10dollarvalue"));

    setValue("b12", getIntValue("w2b16"));
    setValue("b13", getIntValue("f1040b37"));
    setValue("b14", getIntValue("f540schedulecab37b"));
    setValue("b15", getIntValue("b13") - getIntValue("b14"));
    setValue("b16", getIntValue("f540schedulecab37c"));
    setValue("b17", getIntValue("b15") + getIntValue("b16"));
    setValue("b18", Math.max(3992, getIntValue("f540schedulecab44")));
    setValue("b19", getIntValue("b17") - getIntValue("b18"));

    int b19 = getIntValue("b19");
    Preconditions.checkState(b19 < 311812
            && getStringValue("b31checkbox").equals("Tax Rate Schedule"),
        TaxUtil.additionalLogicNeededString(this, "31"));
    if (b19 < 7749) {
      setValue("b31", Math.round(.01f * b19));
    } else if (b19 < 18371) {
      setValue("b31", Math.round(.02f * (b19 - 7749) + 77.49f));
    } else if (b19 < 28995) {
      setValue("b31", Math.round(.04f * (b19 - 18371) + 289.93f));
    } else if (b19 < 40250) {
      setValue("b31", Math.round(.06f * (b19 - 28995) + 714.89f));
    } else if (b19 < 50869) {
      setValue("b31", Math.round(.08f * (b19 - 40250) + 1390.19f));
    } else if (b19 < 259844) {
      setValue("b31", Math.round(.093f * (b19 - 50869) + 2239.71f));
    } else if (b19 < 311812) {
      setValue("b31", Math.round(.103f * (b19 - 259844) + 21674.39f));
    }

    {
      F540AgiLimitationWorksheetTaxYear2014 form = new F540AgiLimitationWorksheetTaxYear2014();
      form.readFromMotherForm(this);
      setValue("b32", form.getIntValue("bresult"));
    }
    setValue("b33", Math.max(0, getIntValue("b31") - getIntValue("b32")));
    setValue("b35", getIntValue("b33") + getIntValue("b34"));

    setValue("b47", getIntValue("b40") + getIntValue("b43") + getIntValue("b44") +
        + getIntValue("b45") + getIntValue("b46"));
    setValue("b48", getIntValue("b35") - getIntValue("b47"));

    setValue("b64", getIntValue("b48") + getIntValue("b61") + getIntValue("b62")
        + getIntValue("b63"));

    setValue("b71", getIntValue("w2b17"));
    setValue("b75", getIntValue("b71") + getIntValue("b72") + getIntValue("b73")
        + getIntValue("b74"));

    setValue("b91", Math.max(0, getIntValue("b75") - getIntValue("b64")));
    setValue("b93", getIntValue("b91") - getIntValue("b92"));
    setValue("b94", Math.max(0, getIntValue("b64") - getIntValue("b75")));


    setValue("b110",
        getIntValue("b400")
        + getIntValue("b401")
        + getIntValue("b403")
        + getIntValue("b405")
        + getIntValue("b406")
        + getIntValue("b407")
        + getIntValue("b408")
        + getIntValue("b410")
        + getIntValue("b413")
        + getIntValue("b419")
        + getIntValue("b422")
        + getIntValue("b423")
        + getIntValue("b424")
        + getIntValue("b425")
        + getIntValue("b426")
        + getIntValue("b427")
        + getIntValue("b428")
        + getIntValue("b429"));

    setValue("b111", getIntValue("b94") + getIntValue("b95") + getIntValue("b110"));

    setValue("b115", getIntValue("b93") - getIntValue("b95") - getIntValue("b110"));
    setValue("b116", getIntValue("b115"));
  }
}
