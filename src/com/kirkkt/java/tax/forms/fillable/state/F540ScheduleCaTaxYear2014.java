package com.kirkkt.java.tax.forms.fillable.state;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableList;

// TODO(kirktdev): remove unused imports
import com.kirkkt.java.tax.TaxUtil;
import com.kirkkt.java.tax.forms.BooleanEntry;
import com.kirkkt.java.tax.forms.Form;
import com.kirkkt.java.tax.forms.IntEntry;
import com.kirkkt.java.tax.forms.IntListEntry;
import com.kirkkt.java.tax.forms.StringEntry;
import com.kirkkt.java.tax.forms.fillable.federal.worksheets.ItemizedDeductionsWorksheetTaxYear2014;
import com.kirkkt.java.tax.forms.fillable.federal.F1040ScheduleATaxYear2014;
import com.kirkkt.java.tax.forms.input.InputForm;
import com.kirkkt.java.tax.forms.input.F1099DivTaxYear2014;
import com.kirkkt.java.tax.forms.input.F1099GTaxYear2014;
import com.kirkkt.java.tax.forms.input.F1099RTaxYear2014;
import com.kirkkt.java.tax.forms.input.W2TaxYear2014;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class F540ScheduleCaTaxYear2014 extends Form {

  private static final Map<String, String> INT_ENTRY_KEY_MAP =
      ImmutableMap.<String, String>builder()
          // todo add comments to inputs
          .put("f1040scheduleab4", "")
          .put("f1040scheduleab5", "")
          .put("f1040scheduleab8", "")
          .put("f1040scheduleab9", "")
          .put("f1040scheduleab15", "")
          .put("f1040scheduleab19", "")
          .put("f1040scheduleab20", "")
          .put("f1040scheduleab27", "")
          .put("f1040scheduleab28", "")
          .put("f1099divb1a", "")
          .put("f1099divb1b", "")
          .put("f1099divb2a", "")
          .put("f1099rb1", "")
          .put("f1099gb2", "")
          .put("w2b1", "Wages, salary, tips, etc.")
          .put("w2b17", "")
          .put("b7a", "")
          .put("b7b", "")
          .put("b7c", "")
          .put("b8aa", "")
          .put("b8ab", "")
          .put("b8ac", "")
          .put("b8b", "")
          .put("b9aa", "")
          .put("b9ab", "")
          .put("b9ac", "")
          .put("b9b", "")
          .put("b10a", "")
          .put("b10b", "")
          .put("b11a", "")
          .put("b11c", "")
          .put("b12a", "")
          .put("b12b", "")
          .put("b12c", "")
          .put("b13a", "")
          .put("b13b", "")
          .put("b13c", "")
          .put("b14a", "")
          .put("b14b", "")
          .put("b14c", "")
          .put("b15a", "")
          .put("b15ba", "")
          .put("b15bb", "")
          .put("b15bc", "")
          .put("b16a", "")
          .put("b16ba", "")
          .put("b16bb", "")
          .put("b16bc", "")
          .put("b17a", "")
          .put("b17b", "")
          .put("b17c", "")
          .put("b18a", "")
          .put("b18b", "")
          .put("b18c", "")
          .put("b19a", "")
          .put("b19b", "")
          .put("b20a", "")
          .put("b20ba", "")
          .put("b20bb", "")
          .put("b21a", "")
          .put("b21ab", "")
          .put("b21bb", "")
          .put("b21db", "")
          .put("b21eb", "")
          .put("b21fb", "")
          .put("b21cc", "")
          .put("b21fc", "")
          .put("b22a", "")
          .put("b22b", "")
          .put("b22c", "")
          .put("b23a", "")
          .put("b23b", "")
          .put("b24a", "")
          .put("b24b", "")
          .put("b24c", "")
          .put("b25a", "")
          .put("b25b", "")
          .put("b26a", "")
          .put("b27a", "")
          .put("b28a", "")
          .put("b29a", "")
          .put("b30a", "")
          .put("b31aa", "")
          .put("b31ac", "")
          .put("b32a", "")
          .put("b33a", "")
          .put("b33c", "")
          .put("b34a", "")
          .put("b34b", "")
          .put("b35a", "")
          .put("b35b", "")
          .put("b36a", "")
          .put("b36b", "")
          .put("b36c", "")
          .put("b37a", "")
          .put("b37b", "")
          .put("b37c", "")
          .put("b38", "")
          .put("b39", "")
          .put("b40", "")
          .put("b41", "")
          .put("b42", "")
          .put("b43", "")
          .put("b44", "")
          .build();

  @Override
  public String getFormType() {
    return "F540 Schedule Ca";
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
    setValue("f1040scheduleab4", form.getIntValue("b4"));
    setValue("f1040scheduleab5", form.getIntValue("b5"));
    setValue("f1040scheduleab8", form.getIntValue("b8"));
    setValue("f1040scheduleab9", form.getIntValue("b9"));
    setValue("f1040scheduleab15", form.getIntValue("b15"));
    setValue("f1040scheduleab19", form.getIntValue("b19"));
    setValue("f1040scheduleab20", form.getIntValue("b20"));
    setValue("f1040scheduleab27", form.getIntValue("b27"));
    setValue("f1040scheduleab28", form.getIntValue("b28"));
    doMath();
  }

  public void readFromF1099Div(F1099DivTaxYear2014 form) {
    setValue("f1099divb1a", form.getIntValue("b1a"));
    setValue("f1099divb1b", form.getIntValue("b1b"));
    setValue("f1099divb2a", form.getIntValue("b2a"));
    doMath();
    resetValue("f1099divb1a");
    resetValue("f1099divb1b");
    resetValue("f1099divb2a");
  }

  public void readFromF1099R(F1099RTaxYear2014 form) {
    setValue("f1099rb1", form.getIntValue("b1"));
    doMath();
    resetValue("f1099rb1");
  }

  public void readFromF1099G(F1099GTaxYear2014 form) {
    setValue("f1099gb2", form.getIntValue("b1"));
    doMath();
    resetValue("f1099gb2");
  }

  public void readFromW2(W2TaxYear2014 form) {
    setValue("w2b1", form.getIntValue("b1"));
    setValue("w2b17", form.getIntValue("b17"));
    doMath();
  }

  @Override
  public void doMath() {
    setValue("b7a", getIntValue("w2b1"));
    setValue("b9aa", getIntValue("f1099divb1a"));
    setValue("b9b", getIntValue("f1099divb1b"));
    setValue("b10a", getIntValue("f1099gb2"));
    setValue("b13a", getIntValue("f1099divb2a"));
    setValue("b16a", getIntValue("f1099rb1"));

    setValue("b22a", getIntValue("b22a") + getIntValue("b7a"));
    setValue("b22a", getIntValue("b22a") + getIntValue("b8aa"));
    setValue("b22a", getIntValue("b22a") + getIntValue("b9aa"));
    setValue("b22a", getIntValue("b22a") + getIntValue("b10a"));
    setValue("b22a", getIntValue("b22a") + getIntValue("b11a"));
    setValue("b22a", getIntValue("b22a") + getIntValue("b12a"));
    setValue("b22a", getIntValue("b22a") + getIntValue("b13a"));
    setValue("b22a", getIntValue("b22a") + getIntValue("b14a"));
    setValue("b22a", getIntValue("b22a") + getIntValue("b15ba"));
    setValue("b22a", getIntValue("b22a") + getIntValue("b16ba"));
    setValue("b22a", getIntValue("b22a") + getIntValue("b17a"));
    setValue("b22a", getIntValue("b22a") + getIntValue("b18a"));
    setValue("b22a", getIntValue("b22a") + getIntValue("b19a"));
    setValue("b22a", getIntValue("b22a") + getIntValue("b20ba"));
    setValue("b22a", getIntValue("b22a") + getIntValue("b21a"));

    setValue("b22b", getIntValue("b22b") + getIntValue("b7b"));
    setValue("b22b", getIntValue("b22b") + getIntValue("b8ab"));
    setValue("b22b", getIntValue("b22b") + getIntValue("b9ab"));
    setValue("b22b", getIntValue("b22b") + getIntValue("b10b"));
    setValue("b22b", getIntValue("b22b") + getIntValue("b12b"));
    setValue("b22b", getIntValue("b22b") + getIntValue("b13b"));
    setValue("b22b", getIntValue("b22b") + getIntValue("b14b"));
    setValue("b22b", getIntValue("b22b") + getIntValue("b15bb"));
    setValue("b22b", getIntValue("b22b") + getIntValue("b16bb"));
    setValue("b22b", getIntValue("b22b") + getIntValue("b17b"));
    setValue("b22b", getIntValue("b22b") + getIntValue("b18b"));
    setValue("b22b", getIntValue("b22b") + getIntValue("b19b"));
    setValue("b22b", getIntValue("b22b") + getIntValue("b20bb"));
    setValue("b22b", getIntValue("b22b") + getIntValue("b21ab"));
    setValue("b22b", getIntValue("b22b") + getIntValue("b21bb"));
    setValue("b22b", getIntValue("b22b") + getIntValue("b21db"));
    setValue("b22b", getIntValue("b22b") + getIntValue("b21eb"));
    setValue("b22b", getIntValue("b22b") + getIntValue("b21fb"));

    setValue("b22c", getIntValue("b22c") + getIntValue("b7c"));
    setValue("b22c", getIntValue("b22c") + getIntValue("b8ac"));
    setValue("b22c", getIntValue("b22c") + getIntValue("b9ac"));
    setValue("b22c", getIntValue("b22c") + getIntValue("b11c"));
    setValue("b22c", getIntValue("b22c") + getIntValue("b12c"));
    setValue("b22c", getIntValue("b22c") + getIntValue("b13c"));
    setValue("b22c", getIntValue("b22c") + getIntValue("b14c"));
    setValue("b22c", getIntValue("b22c") + getIntValue("b15bc"));
    setValue("b22c", getIntValue("b22c") + getIntValue("b16bc"));
    setValue("b22c", getIntValue("b22c") + getIntValue("b17c"));
    setValue("b22c", getIntValue("b22c") + getIntValue("b18c"));
    setValue("b22c", getIntValue("b22c") + getIntValue("b21cc"));
    setValue("b22c", getIntValue("b22c") + getIntValue("b21fc"));

    setValue("b37a", getIntValue("b37a") + getIntValue("b22a"));
    setValue("b37a", getIntValue("b37a") + getIntValue("b23a"));
    setValue("b37a", getIntValue("b37a") + getIntValue("b24a"));
    setValue("b37a", getIntValue("b37a") + getIntValue("b25a"));
    setValue("b37a", getIntValue("b37a") + getIntValue("b26a"));
    setValue("b37a", getIntValue("b37a") + getIntValue("b27a"));
    setValue("b37a", getIntValue("b37a") + getIntValue("b28a"));
    setValue("b37a", getIntValue("b37a") + getIntValue("b29a"));
    setValue("b37a", getIntValue("b37a") + getIntValue("b30a"));
    setValue("b37a", getIntValue("b37a") + getIntValue("b31aa"));
    setValue("b37a", getIntValue("b37a") + getIntValue("b32a"));
    setValue("b37a", getIntValue("b37a") + getIntValue("b33a"));
    setValue("b37a", getIntValue("b37a") + getIntValue("b34a"));
    setValue("b37a", getIntValue("b37a") + getIntValue("b35a"));
    setValue("b37a", getIntValue("b37a") + getIntValue("b36a"));

    setValue("b37b", getIntValue("b37b") + getIntValue("b23b"));
    setValue("b37b", getIntValue("b37b") + getIntValue("b24b"));
    setValue("b37b", getIntValue("b37b") + getIntValue("b25b"));
    setValue("b37b", getIntValue("b37b") + getIntValue("b34b"));
    setValue("b37b", getIntValue("b37b") + getIntValue("b35b"));
    setValue("b37b", getIntValue("b37b") + getIntValue("b36b"));

    setValue("b37c", getIntValue("b37c") + getIntValue("b24c"));
    setValue("b37c", getIntValue("b37c") + getIntValue("b31ac"));
    setValue("b37c", getIntValue("b37c") + getIntValue("b33c"));
    setValue("b37c", getIntValue("b37c") + getIntValue("b36c"));

    setValue("b38", getIntValue("f1040scheduleab4") + getIntValue("f1040scheduleab9")
        + getIntValue("f1040scheduleab15") + getIntValue("f1040scheduleab19")
        + getIntValue("f1040scheduleab20") + getIntValue("f1040scheduleab27")
        + getIntValue("f1040scheduleab28"));

    setValue("b39", getIntValue("f1040scheduleab5") + getIntValue("f1040scheduleab8"));
    setValue("b40", getIntValue("b38") - getIntValue("b39"));
    setValue("b42", getIntValue("b40") + getIntValue("b41"));
    // TODO(kirktdev): itemized deduction worksheet for f540 for b43
    setValue("b44", Math.max(getIntValue("b43"), 3992));
  }
}
