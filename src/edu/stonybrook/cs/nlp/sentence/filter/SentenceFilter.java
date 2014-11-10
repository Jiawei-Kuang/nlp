package edu.stonybrook.cs.nlp.sentence.filter;

import java.util.ArrayList;
import java.util.List;

import edu.stonybrook.cs.nlp.common.Constant.InputSentence;

/**
 * This class is used to initialize the select filters
 * for sentence parser.
 * 
 * @author Jiawei Kuang
 * @version 1.0
 * @since Nov. 8, 2014
 */

public class SentenceFilter {
    
    private List<String> sentenceTypes;
    private List<String> sentenceParameters;
    private List<String> interrogatives;
    
    public SentenceFilter() {
        this.sentenceTypes = new ArrayList<>();
        this.sentenceTypes.add(InputSentence.Type.SENTENCE);
        this.sentenceTypes.add(InputSentence.Type.RULE);
        this.sentenceTypes.add(InputSentence.Type.QUESTION);
        this.sentenceTypes.add(InputSentence.Type.CANCEL);
        
        this.sentenceParameters = new ArrayList<>();
        this.sentenceParameters.add(InputSentence.Parameter.STRICT);
        this.sentenceParameters.add(InputSentence.Parameter.DEFEASIBLE);
        
        this.interrogatives = new ArrayList<>();
        this.interrogatives.add(InputSentence.Interrogative.WHAT);
        this.interrogatives.add(InputSentence.Interrogative.WHEN);
        this.interrogatives.add(InputSentence.Interrogative.WHERE);
    }
    
    public List<String> getSentenceTypes() {
        return sentenceTypes;
    }
    public void setSentenceTypes(List<String> sentenceTypes) {
        this.sentenceTypes = sentenceTypes;
    }
    public List<String> getSentenceParameters() {
        return sentenceParameters;
    }
    public void setSentenceParameters(List<String> sentenceParameters) {
        this.sentenceParameters = sentenceParameters;
    }
    public List<String> getInterrogatives() {
        return interrogatives;
    }
    public void setInterrogatives(List<String> interrogatives) {
        this.interrogatives = interrogatives;
    }

}
