package com.kirkkt.javatests.tax;

import com.kirkkt.javatests.tax.forms.fillable.federal.worksheets.ItemizedDeductionsWorksheetTaxYear2014Test;
import com.kirkkt.javatests.tax.forms.fillable.federal.worksheets.F1040QualifiedDividendAndCapitalGainTaxWorksheetTaxYear2014Test;
import com.kirkkt.javatests.tax.forms.fillable.federal.worksheets.F1040TaxComputationWorksheetTaxYear2014Test;
import com.kirkkt.javatests.tax.forms.fillable.federal.worksheets.F1040TaxComputationWorksheetTaxYear2014Test2;
import com.kirkkt.javatests.tax.forms.fillable.federal.worksheets.F6251ExemptionWorksheetTaxYear2014Test;
import com.kirkkt.javatests.tax.forms.fillable.federal.F1040ScheduleATaxYear2014Test;
import com.kirkkt.javatests.tax.forms.fillable.federal.F1040ScheduleBTaxYear2014Test;
import com.kirkkt.javatests.tax.forms.input.F1099DivTaxYear2014Test;
import com.kirkkt.javatests.tax.forms.input.F1099GTaxYear2014Test;
import com.kirkkt.javatests.tax.forms.input.F1099RTaxYear2014Test;
import com.kirkkt.javatests.tax.forms.input.W2TaxYear2014Test;

import com.google.common.collect.ImmutableList;

public class TestRunner {

  public static void main(String[] args) {
    new TestRunner();
  }

  private TestRunner() {
    ImmutableList<FormTest> formTests = ImmutableList.<FormTest>builder()
        // input forms
        .add(new F1099DivTaxYear2014Test())
        .add(new F1099GTaxYear2014Test())
        .add(new F1099RTaxYear2014Test())
        .add(new W2TaxYear2014Test())
        // worksheets
        .add(new F1040QualifiedDividendAndCapitalGainTaxWorksheetTaxYear2014Test())
        .add(new F1040TaxComputationWorksheetTaxYear2014Test())
        .add(new F1040TaxComputationWorksheetTaxYear2014Test2())
        .add(new F6251ExemptionWorksheetTaxYear2014Test())
        .add(new ItemizedDeductionsWorksheetTaxYear2014Test())
        // fillable forms
        .add(new F1040ScheduleATaxYear2014Test())
        .add(new F1040ScheduleBTaxYear2014Test())
        .build();

    for (FormTest formTest : formTests) {
      String message = "Testing form " + formTest.getForm().getFormType();
      if (formTest.getForm().getTaxYear() > 0) {
        message += " tax year " + formTest.getForm().getTaxYear();
      }
      message += " ...";
      System.out.print(message);
      formTest.test();
      System.out.println(" \033[0;32mPASSED\033[0m.");
    }
  }
}
