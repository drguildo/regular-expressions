package io.sjm.regex.rules;

import io.sjm.automata.NFADesign;
import io.sjm.automata.NFARuleBook;

import java.util.UUID;

import static io.sjm.stdlib.datastructures.Sets.buildSet;

public class Literal extends Pattern {
  private Character c;

  public Literal(Character c) {
    this.c = c;
  }

  @Override
  public Integer getPrecedence() {
    return 3;
  }

  @Override
  public String toString() {
    return c.toString();
  }

  @Override
  public NFADesign<UUID> toNFADesign() {
    UUID startState = UUID.randomUUID();
    UUID acceptState = UUID.randomUUID();
    NFARuleBook<UUID> rb = new NFARuleBook<>();
    rb.addRule(startState, c, acceptState);

    return new NFADesign<>(startState, buildSet(acceptState), rb);
  }
}
