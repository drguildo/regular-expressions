package io.sjm.regex;

import io.sjm.automata.FARule;
import io.sjm.automata.NFADesign;
import io.sjm.automata.NFARuleBook;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

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
    NFADesign<UUID> nfa = pattern.toNFADesign();

    UUID newStart = UUID.randomUUID();
    Set<UUID> acceptStates = new HashSet<>(nfa.getAcceptStates());
    acceptStates.add(newStart);

    NFARuleBook<UUID> rb = nfa.getRulebook();
    nfa.getAcceptStates().forEach(s -> rb.add(new FARule<>(s, null, nfa.getStartState())));

    FARule<UUID> empty = new FARule<>(newStart, null, nfa.getStartState());
    rb.add(empty);

    return new NFADesign<>(newStart, acceptStates, rb);
  }
}
