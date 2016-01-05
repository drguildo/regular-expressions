package io.sjm.regex.tests;

import io.sjm.regex.rules.Concatenate;
import io.sjm.regex.rules.Literal;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConcatenateTest {
  private Literal first, second;
  private Concatenate concat;

  @Before
  public void setUp() throws Exception {
    first = new Literal('a');
    second = new Literal('b');
    concat = new Concatenate(first, second);
  }

  @Test
  public void test() {
    assertEquals("ab", concat.toString());
  }

  @Test
  public void testNFADesign() {
    assertTrue(concat.toNFADesign().accepts("ab"));
    assertFalse(concat.toNFADesign().accepts(""));
    assertFalse(concat.toNFADesign().accepts("aa"));
    assertFalse(concat.toNFADesign().accepts("abc"));

    assertFalse(concat.toNFADesign().accepts("a"));
    assertFalse(concat.toNFADesign().accepts("b"));
    assertFalse(concat.toNFADesign().accepts("c"));

    concat = new Concatenate(new Literal('a'), new Concatenate(new Literal('b'), new Literal('c')));
    assertTrue(concat.toNFADesign().accepts("abc"));
    assertFalse(concat.toNFADesign().accepts("abb"));
  }
}
