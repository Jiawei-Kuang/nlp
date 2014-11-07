package edu.stonybrook.cs.nlp.parser.filter;

import java.util.List;

import edu.stonybrook.cs.nlp.common.Constant.SentenceType;
import edu.stonybrook.cs.nlp.common.Constant.SentenceAttributes;
import edu.stonybrook.cs.nlp.common.Constant.Interrogative;


public class SentenceParserFilterSelector {
	public void setSentenceTypes(List<String> sentenceTypes) {
		sentenceTypes.add(SentenceType.SENTENCE);
		sentenceTypes.add(SentenceType.RULE);
		sentenceTypes.add(SentenceType.QUESTION);
	}
	
	public void setSentenceAttributes(List<String> sentenceAttributes) {
		sentenceAttributes.add(SentenceAttributes.STRICT);
		sentenceAttributes.add(SentenceAttributes.DEFEASIBLE);
	}
	
	public void setInterrogative(List<String> interrogative) {
		interrogative.add(Interrogative.WHAT);
		interrogative.add(Interrogative.WHEN);
		interrogative.add(Interrogative.WHERE);
	}
}
