package io.sjm.regex.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import io.sjm.regex.Choose;
import io.sjm.regex.Literal;

public class ChooseTest {
  private Literal first, second;
  private Choose choose;

  @Before
  public void setUp() throws Exception {
    first = new Literal('a');
    second = new Literal('b');
    choose = new Choose(first, second);
  }

  @Test
  public void test() {
    assertEquals("a|b", choose.toString());
  }
}
