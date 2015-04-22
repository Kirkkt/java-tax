package com.kirkkt.javatests.tax;

import com.google.common.collect.UnmodifiableIterator;
import com.google.common.collect.ImmutableList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;

public final class TestUtil {

  private TestUtil() {}  // COV_NF_LINE

  public static final String TEST_DATA_FOLDER =
      "/Users/kirkt/Dropbox/vim_notes/java_programs/data/com/kirkkt/javatests/tax";

  public static UnmodifiableIterator<String> getGold(String fileName) {
    BufferedReader br;
    String line;
    ImmutableList.Builder<String> goldBuilder = ImmutableList.<String>builder();
    try {
      br = new BufferedReader(new FileReader(fileName));
      while ((line = br.readLine()) != null) {
        goldBuilder.add(line);
      }
      br.close();
    } catch (IOException e) {
      throw new IllegalArgumentException("Failed to read file " + fileName + " due to error " + e);
    }
    return goldBuilder.build().iterator();
  }
}
