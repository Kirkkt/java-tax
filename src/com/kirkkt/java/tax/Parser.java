package com.kirkkt.java.tax;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;

import com.kirkkt.java.tax.forms.Form;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;

/**
 * A helper class to host all static parsing logic.
 * </p> Should never be instantiated.
 */
public final class Parser {

  private static final String GENERAL_PARSING_ERROR_MESSAGE = "Error processing line";

  private Parser() {} // COV_NF_LINE

  /**
   * Parses a string and round the result into int. Throws error message on error.
   *
   * @param text the string to be parsed
   * @param lineContext the line containing {@param text} that can provide the context of where it
   *   is from.
   */
  public static int parseAndRound(String text, String lineContext) {
    try {
      return Math.round(Float.parseFloat(text));
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException(
          genericParsingErrorMessage(lineContext) + "\nDetail:\n  " + e.toString());
    }
  }

  /**
   * Returns a string describing a parsing error message.
   *
   * @param lineContext the string being parsed
   */
  public static String genericParsingErrorMessage(String lineContext) {
    return String.format("%s: \n  %s", GENERAL_PARSING_ERROR_MESSAGE, lineContext);
  }
}
