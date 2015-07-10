package io.sjm.regex;

import static io.sjm.stdlib.datastructures.Sets.buildSet;

import java.util.UUID;

import io.sjm.automata.NFADesign;
import io.sjm.automata.NFARuleBook;

public class Empty extends Pattern {
  @Override
  public Integer getPrecedence() {
    return 3;
  }

  @Override
  public String toString() {
    return "";
  }

  @Override
  public NFADesign<UUID> toNFADesign() {
    UUID u = UUID.randomUUID();
    return new NFADesign<>(u, buildSet(u), new NFARuleBook<>());
  }
}
