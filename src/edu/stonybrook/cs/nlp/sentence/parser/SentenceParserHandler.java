package edu.stonybrook.cs.nlp.sentence.parser;

import org.springframework.beans.factory.annotation.Autowired;

import ch.uzh.ifi.attempto.ape.ACEParserException;
import ch.uzh.ifi.attempto.ape.Message;
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
        try {
            sentence.setDrs(sentenceParser.parseToDRS(sentence.getSentence()));
            sentence.setDrsParseSuccess(true);
        } catch (ACEParserException e) {
            StringBuilder sb = new StringBuilder();
            for (Message m : e.getMessageContainer().getErrorMessages()) {
                sb.append(m.toString());
                sb.append('\n');
            }
            sentence.setDrs(sb.toString());
            sentence.setDrsParseSuccess(false);
        }
        try {
            sentence.setFol(sentenceParser.parseToFOL(sentence.getSentence()));
            sentence.setFolParseSuccess(true);
        } catch (ACEParserException e) {
            StringBuilder sb = new StringBuilder();
            for (Message m : e.getMessageContainer().getErrorMessages()) {
                sb.append(m.toString());
                sb.append('\n');
            }
            sentence.setFol(sb.toString());
            sentence.setFolParseSuccess(false);
        }
    }
}
