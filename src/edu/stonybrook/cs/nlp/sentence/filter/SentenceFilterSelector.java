package edu.stonybrook.cs.nlp.sentence.filter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * This class is used to get the select filter
 * for sentence parser.
 * 
 * @author Jiawei Kuang
 * @version 1.0
 * @since Nov. 8, 2014
 */

public class SentenceFilterSelector {
    
    @Autowired
    private SentenceFilter sentenceFilter;

    public List<String> getAllSentenceParameters() {
        return this.sentenceFilter.getSentenceParameters();
    }
}
