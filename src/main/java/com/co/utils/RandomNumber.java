package com.co.utils;

import java.util.concurrent.ThreadLocalRandom;

/** Utility class for generating random numbers. */
public final class RandomNumber {

  private RandomNumber() {
    throw new IllegalStateException("Utility class");
  }

  /**
   * Generates a random long value between 0 (inclusive) and 10000 (exclusive).
   *
   * @return A random long value.
   */
  public static Long getValue() {
    return ThreadLocalRandom.current().nextLong(10000);
  }
}
