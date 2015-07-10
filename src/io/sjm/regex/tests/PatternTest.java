package io.sjm.regex.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import io.sjm.regex.Choose;
import io.sjm.regex.Concatenate;
import io.sjm.regex.Literal;
import io.sjm.regex.Pattern;
import io.sjm.regex.Repeat;

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
