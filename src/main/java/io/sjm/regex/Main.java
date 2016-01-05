package io.sjm.regex;

import io.sjm.automata.DFADesign;
import io.sjm.automata.NFADesign;
import io.sjm.automata.NFARuleBook;
import io.sjm.automata.NFASimulation;
import org.parboiled.Parboiled;
import org.parboiled.parserunners.ReportingParseRunner;
import org.parboiled.support.ParseTreeUtils;
import org.parboiled.support.ParsingResult;

import java.util.Set;

import static io.sjm.sjmlib.datastructures.Sets.buildSet;

public class Main {
  public static void main(String[] args) {
    NFARuleBook<Integer> rulebook = new NFARuleBook<>();

    rulebook.addRule(1, 'a', 1);
    rulebook.addRule(1, 'a', 2);
    rulebook.addRule(1, null, 2);

    rulebook.addRule(2, 'b', 3);

    rulebook.addRule(3, 'b', 1);
    rulebook.addRule(3, null, 2);

    NFADesign<Integer> nfaDesign = new NFADesign<>(1, buildSet(3), rulebook);
    NFASimulation<Integer> simulation = new NFASimulation<>(nfaDesign);
    DFADesign<Set<Integer>> dfaDesign = simulation.toDFADesign();

    System.out.println(dfaDesign.getRulebook());
    System.out.println(dfaDesign.getStartState());
    System.out.println(dfaDesign.getAcceptStates());
    System.out.println(dfaDesign.accepts("aaa"));
    System.out.println(dfaDesign.accepts("aab"));
    System.out.println(dfaDesign.accepts("bbbabb"));
  }

  private static void parserExample() {
    String s = "(a(|b))*";

    RegexParser parser = Parboiled.createParser(RegexParser.class);
    ParsingResult<?> result = new ReportingParseRunner(parser.Choose()).run(s);
    String parseTreePrintOut = ParseTreeUtils.printNodeTree(result);
    System.out.println(parseTreePrintOut);
  }
}
