package io.sjm.regex.tests;

import io.sjm.regex.rules.Empty;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
