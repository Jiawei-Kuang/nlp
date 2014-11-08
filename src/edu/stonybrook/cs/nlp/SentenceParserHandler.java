package edu.stonybrook.cs.nlp;

import org.springframework.beans.factory.annotation.Autowired;

public class SentenceParserHandler {
	
	@Autowired
	private SentenceParser sentenceParser;
	
	public void parse(Sentence sentence) {
		sentence.setDrs(sentenceParser.parseToDRS(sentence.getSentence()));
		sentence.setFol(sentenceParser.parseToFOL(sentence.getSentence()));
	}
}
