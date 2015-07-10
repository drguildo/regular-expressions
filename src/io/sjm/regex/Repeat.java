package io.sjm.regex;

import java.util.UUID;

import io.sjm.automata.NFADesign;

public class Repeat extends Pattern {
  private Pattern pattern;

  public Repeat(Pattern pattern) {
    this.pattern = pattern;
  }

  @Override
  public Integer getPrecedence() {
    return 2;
  }

  @Override
  public String toString() {
    return pattern.bracket(getPrecedence()) + "*";
  }

  @Override
  public NFADesign<UUID> toNFADesign() {
    return null;
  }
}
