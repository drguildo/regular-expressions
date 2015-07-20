package io.sjm.regex.tests;

import io.sjm.automata.NFADesign;
import io.sjm.regex.Choose;
import io.sjm.regex.Literal;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.*;

public class ChooseTest {
  private Choose choose;
  private NFADesign<UUID> nfa;

  @Before
  public void setUp() throws Exception {
    choose = new Choose(new Literal('a'), new Literal('b'));
    nfa = choose.toNFADesign();
  }

  @Test
  public void test() {
    assertEquals("a|b", choose.toString());
  }

  @Test
  public void testToNFADesign() throws Exception {
    assertTrue(nfa.accepts("a"));
    assertTrue(nfa.accepts("b"));

    assertFalse(nfa.accepts(""));
    assertFalse(nfa.accepts("c"));
    assertFalse(nfa.accepts("ab"));
    assertFalse(nfa.accepts("ba"));
  }
}
