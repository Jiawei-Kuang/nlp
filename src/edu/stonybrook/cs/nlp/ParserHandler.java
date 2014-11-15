package edu.stonybrook.cs.nlp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import edu.stonybrook.cs.nlp.common.Constant.InputSentence;
import edu.stonybrook.cs.nlp.exception.SentenceInvalidException;
import edu.stonybrook.cs.nlp.sentence.Sentence;
import edu.stonybrook.cs.nlp.sentence.SentencesSelector;
import edu.stonybrook.cs.nlp.sentence.filter.SentenceFilterSelector;
import edu.stonybrook.cs.nlp.sentence.parser.SentenceParserHandler;

/**
 * This class is used to handle the information from parser 
 * and return processed information back to parser.
 * 
 * @author Jiawei Kuang
 * @version 1.0
 * @since Nov. 8, 2014
 */

public class ParserHandler {
    
    @Autowired
    private SentenceFilterSelector sentenceFilterSelector;
    
    @Autowired
    private SentencesSelector sentencesSelector;
    
    @Autowired
    private SentenceParserHandler sentenceParserHandler;
    
    /**
     * This method does three kind of objects to model.
     * 1. Put the sentence filters information into model.
     * 2. Get sentence related information from SentenceSelector
     *    and then put to model.
     * 3. Parse sentences into phrase structure tree (i.e. drs and fol)
     *    and then put to model.
     * 
     * @param request
     * @return model for parser page
     */
    public Map<String, Object> getModel(HttpServletRequest request) {
        Map<String, Object> model = new HashMap<>();
        model.put(InputSentence.SENTENCE_PARAMETERS, sentenceFilterSelector.getAllSentenceParameters());
        model.put(InputSentence.SENTENCE_PARAMETER, InputSentence.SENTENCE_PARAMETER);
        model.put(InputSentence.SENTENCE_TYPES, sentenceFilterSelector.getAllSentenceTypes());
        model.put(InputSentence.SENTENCE_TYPE, InputSentence.SENTENCE_TYPE);
        model.put(InputSentence.QUESTION_TYPES, sentenceFilterSelector.getAllInterrogatives());
        model.put(InputSentence.QUESTION_TYPE, InputSentence.QUESTION_TYPE);
        model.put(InputSentence.IS_VALID_SENTENCE, true);
        List<Sentence> sentencesList = sentencesSelector.getSentences(request);
        model.put(InputSentence.SENTENCES, sentencesList);
        
        if (!sentencesList.isEmpty()) {
            try {
                Sentence sentence = sentencesList.get(0);
                sentenceParserHandler.parse(sentence);
            } catch (SentenceInvalidException e) {
                model.put(InputSentence.IS_VALID_SENTENCE, false);
            }
        }
        
        return model;
    }
}
