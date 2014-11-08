package edu.stonybrook.cs.nlp.sentence.filter;

import java.util.ArrayList;
import java.util.List;

public class SentenceFilter {

	private SentenceFilterSelector sentenceFilterSelector;

	public SentenceFilter(SentenceFilterSelector sentenceFilterSelector){
		this.sentenceFilterSelector = sentenceFilterSelector;
	}

	public List<String> getAllSentenceTypes() {
		List<String> sentenceTypes = new ArrayList<>();
		this.sentenceFilterSelector.setSentenceTypes(sentenceTypes);
		return sentenceTypes;
	}
	
	public List<String> getAllSentenceParameters() {
		List<String> sentenceParameters = new ArrayList<>();
		this.sentenceFilterSelector.setSentenceParameters(sentenceParameters);
		return sentenceParameters;
	}
	
	public List<String> getAllInterrogatives() {
		List<String> interrogatives = new ArrayList<>();
		this.sentenceFilterSelector.setInterrogatives(interrogatives);
		return interrogatives;
	}
}
