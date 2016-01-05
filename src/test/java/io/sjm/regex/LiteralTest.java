package io.sjm.regex.tests;

import io.sjm.regex.rules.Literal;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LiteralTest {
  private Literal l;

  @Test
  public void test() {
    l = new Literal('a');
    assertTrue(l.matches("a"));
    assertFalse(l.matches("b"));
    assertFalse(l.matches("aa"));
    assertFalse(l.matches("ab"));
    assertFalse(l.matches(""));
    l = new Literal('b');
    assertTrue(l.matches("b"));
    assertFalse(l.matches("a"));
    assertFalse(l.matches("bb"));
    assertFalse(l.matches("ba"));
    assertFalse(l.matches(""));
  }
}
