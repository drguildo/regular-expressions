package io.sjm.regex;

import java.util.UUID;

import io.sjm.automata.NFADesign;

public abstract class Pattern {
  public String bracket(Integer outerPrecedence) {
    if (getPrecedence() < outerPrecedence)
      return "(" + this.toString() + ")";
    return this.toString();
  }

  public Boolean matches(String s) {
    return toNFADesign().accepts(s);
  }

  abstract public Integer getPrecedence();

  abstract public NFADesign<UUID> toNFADesign();
}
