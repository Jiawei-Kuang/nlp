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
    
    private List<String> sentenceParameters;
    
    public SentenceFilter() {
        this.sentenceParameters = new ArrayList<>();
        this.sentenceParameters.add(InputSentence.Parameter.STRICT);
        this.sentenceParameters.add(InputSentence.Parameter.DEFEASIBLE);
    }
    
    public List<String> getSentenceParameters() {
        return sentenceParameters;
    }
    public void setSentenceParameters(List<String> sentenceParameters) {
        this.sentenceParameters = sentenceParameters;
    }
}
