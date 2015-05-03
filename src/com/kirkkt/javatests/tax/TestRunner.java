package com.kirkkt.javatests.tax;

import com.kirkkt.javatests.tax.forms.TaxUtilTest;
import com.kirkkt.javatests.tax.forms.fillable.federal.worksheets.ItemizedDeductionsWorksheetTaxYear2014Test;
import com.kirkkt.javatests.tax.forms.fillable.federal.worksheets.F1040QualifiedDividendAndCapitalGainTaxWorksheetTaxYear2014Test;
import com.kirkkt.javatests.tax.forms.fillable.federal.worksheets.F1040TaxComputationWorksheetTaxYear2014Test;
import com.kirkkt.javatests.tax.forms.fillable.federal.worksheets.F6251ExemptionWorksheetTaxYear2014Test;
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
    ImmutableList<TestCase> testCases = ImmutableList.<TestCase>of(
      // Add new tests here.
      new TaxUtilTest(),
      // worksheets
      new F1040QualifiedDividendAndCapitalGainTaxWorksheetTaxYear2014Test(),
      new F1040TaxComputationWorksheetTaxYear2014Test(),
      new F6251ExemptionWorksheetTaxYear2014Test(),
      new ItemizedDeductionsWorksheetTaxYear2014Test(),
      // input forms
      new F1099GTaxYear2014Test(),
      new F1099RTaxYear2014Test()
    );

    ImmutableList<FormTest> formTests = ImmutableList.<FormTest>builder()
        .add(new F1099DivTaxYear2014Test())
        .add(new W2TaxYear2014Test())
        .build();

    for (TestCase testCase : testCases) {
      String message = "Testing form " + testCase.getForm().getFormType();
      if (testCase.getForm().getTaxYear() > 0) {
        message += " tax year " + testCase.getForm().getTaxYear();
      }
      message += " ...";
      System.out.print(message);
      testCase.test();
      System.out.println(" \033[0;32mPASSED\033[0m.");
    }

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
