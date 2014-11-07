package edu.stonybrook.cs.nlp.common;

/**
 * 
 * @author Jiawei Kuang
 * @version 1.0
 * @since Nov. 1, 2014
 */
public class Constant {
	public interface Interrogative {
		public final String WHAT 	= "What";
		public final String WHERE 	= "Where";
		public final String WHEN 	= "When";
	}
	
	public interface SentenceType {
		public final String SENTENCE 	= "Sentence";
		public final String RULE 		= "Rule";
		public final String QUESTION 	= "Question";
	}
	
	public interface SentenceAttributes {
		public final String STRICT 		= "Strict";
		public final String DEFEASIBLE 	= "Defeasible";
	}
}
