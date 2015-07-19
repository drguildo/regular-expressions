package io.sjm.regex;

import io.sjm.automata.NFADesign;

import java.util.UUID;

public class Choose extends Pattern {
  private Pattern first;
  private Pattern second;

  public Choose(Pattern first, Pattern second) {
    this.first = first;
    this.second = second;
  }

  @Override
  public Integer getPrecedence() {
    return 0;
  }

  @Override
  public String toString() {
    return "/" + first.bracket(getPrecedence()) + second.bracket(getPrecedence()) + "/";
  }

  @Override
  public NFADesign<UUID> toNFADesign() {
    return null;
  }
}
