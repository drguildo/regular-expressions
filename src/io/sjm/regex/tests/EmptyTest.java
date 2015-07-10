package io.sjm.regex.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import io.sjm.regex.Empty;

public class EmptyTest {
  private Empty e;

  @Before
  public void setUp() throws Exception {
    e = new Empty();
  }

  @Test
  public void test() {
    assertTrue(e.matches(""));
    assertFalse(e.matches("a"));
  }
}
