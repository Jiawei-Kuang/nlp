package edu.stonybrook.cs.nlp.sentence.parser;

import org.springframework.beans.factory.annotation.Autowired;

import ch.uzh.ifi.attempto.ape.ACEParserException;
import ch.uzh.ifi.attempto.ape.Message;
import ch.uzh.ifi.attempto.ape.MessageContainer;
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
    
    /**
     * Parser sentence, the DRS and FOL result is store in sentence itself.
     * @param sentence
     */
    public void parse(Sentence sentence) {
        String sentenceString = sentence.getSentence();
        try {
            String drs = sentenceParser.parseToDRS(sentenceString);
            sentence.setDrs(drs);
            sentence.setDrsParseSuccess(true);
        } catch (ACEParserException e) {
            String errMsg = getACEParserExceptionErrorMessage(e);
            sentence.setDrs(errMsg);
            sentence.setDrsParseSuccess(false);
        }
        try {
            String fol = sentenceParser.parseToFOL(sentenceString);
            sentence.setFol(fol);
            sentence.setFolParseSuccess(true);
        } catch (ACEParserException e) {
            String errMsg = getACEParserExceptionErrorMessage(e);
            sentence.setFol(errMsg);
            sentence.setFolParseSuccess(false);
        }
    }
    
    private String getACEParserExceptionErrorMessage(ACEParserException e) {
        StringBuilder errMsg = new StringBuilder();
        MessageContainer messageContainer = e.getMessageContainer();
        for (Message m : messageContainer.getErrorMessages()) {
            errMsg.append(m.toString());
            errMsg.append('\n');
        }
        return errMsg.toString();
    }
}
