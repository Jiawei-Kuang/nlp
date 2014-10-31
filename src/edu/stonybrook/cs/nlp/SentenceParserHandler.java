package edu.stonybrook.cs.nlp;
public class SentenceParserHandler {
	public static void parse(Sentence sentence, SentenceParser parser) {
		sentence.setDrs(parser.parseToDRS(sentence.getSentence()));
		sentence.setFol(parser.parseToFOL(sentence.getSentence()));
	}
}
