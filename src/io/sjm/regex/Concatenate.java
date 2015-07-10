package io.sjm.regex;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import io.sjm.automata.FARule;
import io.sjm.automata.NFADesign;
import io.sjm.automata.NFARuleBook;

public class Concatenate extends Pattern {
  private Pattern first;
  private Pattern second;

  public Concatenate(Pattern first, Pattern second) {
    this.first = first;
    this.second = second;
  }

  @Override
  public Integer getPrecedence() {
    return 1;
  }

  @Override
  public String toString() {
    List<Pattern> patterns = Arrays.asList(first, second);
    return String.join("", patterns.stream().map(pattern -> pattern.bracket(getPrecedence()))
        .collect(Collectors.toList()));
  }

  @Override
  public NFADesign<UUID> toNFADesign() {
    NFADesign<UUID> fnd = first.toNFADesign();
    NFADesign<UUID> snd = second.toNFADesign();

    UUID startState = fnd.getStartState();
    Set<UUID> acceptStates = snd.getAcceptStates();

    NFARuleBook<UUID> newRules = new NFARuleBook<>();
    newRules.addAll(fnd.getRulebook());
    newRules.addAll(snd.getRulebook());

    Set<FARule<UUID>> extraRules = fnd.getAcceptStates().stream()
        .map(state -> new FARule<>(state, null, snd.getStartState())).collect(Collectors.toSet());
    newRules.addAll(extraRules);

    return new NFADesign<>(startState, acceptStates, newRules);
  }
}
