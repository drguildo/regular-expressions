package io.sjm.regex.tests;

import io.sjm.regex.rules.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PatternTest {
  private Pattern p;

  @Before
  public void setUp() throws Exception {
    p = new Repeat(
        new Choose(new Concatenate(new Literal('a'), new Literal('b')), new Literal('a')));
  }

  @Test
  public void test() {
    assertEquals("(ab|a)*", p.toString());
  }
}
