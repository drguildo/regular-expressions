package io.sjm.regex;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import io.sjm.automata.NFADesign;

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
    List<Pattern> patterns = Arrays.asList(first, second);
    return String.join("|", patterns.stream().map(pattern -> pattern.bracket(getPrecedence()))
        .collect(Collectors.toList()));
  }

  @Override
  public NFADesign<UUID> toNFADesign() {
    return null;
  }
}
