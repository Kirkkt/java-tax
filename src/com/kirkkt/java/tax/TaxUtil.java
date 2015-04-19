package com.kirkkt.java.tax;

import com.kirkkt.java.tax.forms.Form;

import com.google.common.base.Preconditions;

import java.io.BufferedReader;
import java.io.FileReader;

// TODO(kirktdev): singleton?
public final class TaxUtil {

  // TODO(kirktdev): relative path can?
  public static final String DATA_FOLDER =
      "/Users/kirkt/Dropbox/vim_notes/java_programs/data/com/kirkkt/java/tax";

  private String checkingAccountRoutingNumber;
  private String checkingAccountAccountNumber;
  private String checkingAccountAccountType;
  private String employerIdentificationNumber;
  private String employerAddress;
  private String employerStateIdNumber;

  /**
   * Parses a line of string and round the result into int. Throws error message on error.
   *
   * @param line a string with components separated by {@code " "}
   * @param parts the number of {@code " "} this string should have. Only the last part, defined by
   *   the sepration of {@code " "} will be parsed and rounded.
   */
  public static int parseAndRoundToInt(String line, int parts) {
    try {
      return Math.round(Float.parseFloat(line.split(" ", parts)[parts - 1]));
    } catch (NumberFormatException e) {
      throw new NumberFormatException(
          genericParsingErrorMessage(line) + "\nDetail:\n  " + e.toString());
    }
  }

  /**
   * Returns a string describing a parsing error message.
   *
   * @param line the string being parsed
   */
  public static String genericParsingErrorMessage(String text) {
    return String.format("%s: \n  %s", genericParsingErrorMessage(), text);
  }

  /**
   * Returns a string describing a parsing error message.
   */
  public static String genericParsingErrorMessage() {
    return "Error processing line";
  }

  /**
   * Return a standard error message string describing that additional logic is
   * needed form the given form.
   * </p>If this happens, java_tax might not be right for you.
   *
   * @param form the form currently being processed
   */
  public static String additionalLogicNeededString(Form form) {
    return "Additional logic needed for form "
        + form.getFormType() + " of tax year "
        + form.getTaxYear() + ".";
  }

  /**
   * Return a standard error message string describing that additional logic is
   * needed on a specific line in the given form.
   * </p>If this happens, java_tax might not be right for you.
   *
   * @param form the form currently being processed
   * @param line the line name where additional logic is needed
   */
  public static String additionalLogicNeededString(Form form, String line) {
    return "Additional logic needed for form "
        + form.getFormType() + " of tax year "
        + form.getTaxYear() + " on line "
        + line + ".";
  }

  public TaxUtil() {
    BufferedReader br;
    String line;
    String fileName = DATA_FOLDER + "/common.txt";
    try {
      br = new BufferedReader(new FileReader(fileName));
      while ((line = br.readLine()) != null) {
        if (line.equals("common")) {
          // heading
          // TODO(kirktdev): switch to use custom parsing method
        } else if (line.startsWith("checking account routing number ")) {
          checkingAccountRoutingNumber = line.split(" ", 5)[4];
        } else if (line.startsWith("checking account account number ")) {
          checkingAccountAccountNumber = line.split(" ", 5)[4];
        } else if (line.startsWith("checking account account type ")) {
          checkingAccountAccountType = line.split(" ", 5)[4];
        } else if (line.startsWith("employer identification number ")) {
          employerIdentificationNumber = line.split(" ", 4)[3];
        } else if (line.startsWith("employer address ")) {
          employerAddress = line.split(" ", 3)[2];
        } else if (line.startsWith("employer state id number ")) {
          employerStateIdNumber = line.split(" ", 5)[4];
        } else {
          br.close();
          throw new IllegalArgumentException("Invalid input line: " + line);
        }
      }
      br.close();
    } catch (Exception e) {
      throw new IllegalArgumentException("Failed to read file " + fileName + " due to error " + e);
    }
  }

  public String getCheckingAccountRoutingNumber() {
    return checkingAccountRoutingNumber;
  }

  public String getCheckingAccountAccountNumber() {
    return checkingAccountAccountNumber;
  }

  public String getCheckingAccountAccountType() {
    return checkingAccountAccountType;
  }

  public String getEmployerIdentificationNumber() {
    return employerIdentificationNumber;
  }

  public String getEmployerAddress() {
    return employerAddress;
  }

  public String getEmployerStateIdNumber() {
    return employerStateIdNumber;
  }

}
