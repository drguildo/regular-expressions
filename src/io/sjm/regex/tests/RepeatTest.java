package io.sjm.regex.tests;

import io.sjm.automata.NFADesign;
import io.sjm.regex.Literal;
import io.sjm.regex.Repeat;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RepeatTest {
  Repeat repeat;

  @Before
  public void setUp() throws Exception {
    repeat = new Repeat(new Literal('a'));
  }

  @Test
  public void testToNFADesign() {
    NFADesign<UUID> nfa = repeat.toNFADesign();

    assertTrue(nfa.accepts(""));
    assertTrue(nfa.accepts("a"));
    assertTrue(nfa.accepts("aa"));
    assertTrue(nfa.accepts("aaa"));

    assertFalse(nfa.accepts("b"));
    assertFalse(nfa.accepts("bb"));
    assertFalse(nfa.accepts("bbb"));
  }
}
