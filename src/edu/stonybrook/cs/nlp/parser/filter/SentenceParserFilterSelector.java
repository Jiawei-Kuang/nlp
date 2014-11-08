package edu.stonybrook.cs.nlp.parser.filter;

import java.util.List;

import edu.stonybrook.cs.nlp.common.Constant.InputSentence;


public class SentenceParserFilterSelector {
	public void setSentenceTypes(List<String> sentenceTypes) {
		sentenceTypes.add(InputSentence.Type.SENTENCE);
		sentenceTypes.add(InputSentence.Type.RULE);
		sentenceTypes.add(InputSentence.Type.QUESTION);
	}
	
	public void setSentenceParameters(List<String> sentenceAttributes) {
		sentenceAttributes.add(InputSentence.Parameter.STRICT);
		sentenceAttributes.add(InputSentence.Parameter.DEFEASIBLE);
	}
	
	public void setInterrogatives(List<String> interrogative) {
		interrogative.add(InputSentence.Interrogative.WHAT);
		interrogative.add(InputSentence.Interrogative.WHEN);
		interrogative.add(InputSentence.Interrogative.WHERE);
	}
}
