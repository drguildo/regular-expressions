package io.sjm.regex;

import org.parboiled.BaseParser;
import org.parboiled.Rule;
import org.parboiled.annotations.BuildParseTree;

@BuildParseTree
public class RegexParser extends BaseParser<Object> {
  Rule Choose() {
    return FirstOf(Sequence(ConcatenateOrEmpty(), '|', Choose()), ConcatenateOrEmpty());
  }

  Rule ConcatenateOrEmpty() {
    return FirstOf(Concatenate(), EMPTY);
  }

  Rule Concatenate() {
    return FirstOf(Sequence(Repeat(), Concatenate()), Repeat());
  }

  Rule Repeat() {
    return FirstOf(Sequence(Brackets(), '*'), Brackets());
  }

  Rule Brackets() {
    return FirstOf(Sequence('(', Choose(), ')'), Literal());
  }

  Rule Literal() {
    return CharRange('a', 'z');
  }
}
