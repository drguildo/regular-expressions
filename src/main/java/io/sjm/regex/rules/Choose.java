package io.sjm.regex.rules;

import io.sjm.automata.FARule;
import io.sjm.automata.NFADesign;
import io.sjm.automata.NFARuleBook;
import io.sjm.sjmlib.datastructures.Sets;

import java.util.Set;
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
    return first.bracket(getPrecedence()) + "|" + second.bracket(getPrecedence());
  }

  @Override
  public NFADesign<UUID> toNFADesign() {
    NFADesign<UUID> fst = first.toNFADesign();
    NFADesign<UUID> snd = second.toNFADesign();

    UUID startState = UUID.randomUUID();
    Set<UUID> acceptStates = Sets.union(fst.getAcceptStates(), snd.getAcceptStates());
    NFARuleBook<UUID> newRules = new NFARuleBook<>();
    newRules.addAll(fst.getRulebook());
    newRules.addAll(snd.getRulebook());

    newRules.add(new FARule<>(startState, null, fst.getStartState()));
    newRules.add(new FARule<>(startState, null, snd.getStartState()));

    return new NFADesign<>(startState, acceptStates, newRules);
  }
}
