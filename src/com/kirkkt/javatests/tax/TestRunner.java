package com.kirkkt.javatests.tax;

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
      new F1099DivTaxYear2014Test(),
      new F1099GTaxYear2014Test(),
      new F1099RTaxYear2014Test(),
      new W2TaxYear2014Test()
    );

    for (TestCase testCase : testCases) {
      testCase.test();
      System.out.println(String.format("Test passed for form %s tax year %s.",
          testCase.getForm().getFormType(), testCase.getForm().getTaxYear()));
    }
  }
}
