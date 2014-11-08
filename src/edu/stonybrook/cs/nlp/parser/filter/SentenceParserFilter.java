package edu.stonybrook.cs.nlp.parser.filter;

import java.util.ArrayList;
import java.util.List;

public class SentenceParserFilter {

	private SentenceParserFilterSelector sentenceParserFilterSelector;

	public SentenceParserFilter(SentenceParserFilterSelector sentenceParserFilterSelector){
		this.sentenceParserFilterSelector = sentenceParserFilterSelector;
	}

	public List<String> getAllSentenceTypes() {
		List<String> sentenceTypes = new ArrayList<>();
		sentenceParserFilterSelector.setSentenceTypes(sentenceTypes);
		return sentenceTypes;
	}
	
	public List<String> getAllSentenceParameters() {
		List<String> sentenceParameters = new ArrayList<>();
		sentenceParserFilterSelector.setSentenceParameters(sentenceParameters);
		return sentenceParameters;
	}
	
	public List<String> getAllInterrogatives() {
		List<String> interrogatives = new ArrayList<>();
		sentenceParserFilterSelector.setInterrogatives(interrogatives);
		return interrogatives;
	}
}
