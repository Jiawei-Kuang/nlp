package edu.stonybrook.cs.nlp.sentence.parser;

import org.springframework.beans.factory.annotation.Autowired;

import edu.stonybrook.cs.nlp.sentence.Sentence;

/**
 * 
 * @author Jiawei Kuang
 * @version 1.0
 * @since Nov. 8, 2014
 */

public class SentenceParserHandler {
    
    @Autowired
    private SentenceParser sentenceParser;
    
    public void parse(Sentence sentence) {
        sentence.setDrs(sentenceParser.parseToDRS(sentence.getSentence()));
        sentence.setFol(sentenceParser.parseToFOL(sentence.getSentence()));
    }
}
