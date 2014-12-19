package edu.stonybrook.cs.nlp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import edu.stonybrook.cs.nlp.common.Constant.InputSentence;
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
     * This method adds three kind of objects to model.
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
        List<Sentence> sentencesList = sentencesSelector.getSentences(request);
        List<Integer> exceptionOptions = new ArrayList<>();
        for (int i = 0; i < sentencesList.size(); i++) {
            exceptionOptions.add(i + 1);
            Sentence sentence = sentencesList.get(i);
            sentenceParserHandler.parse(sentence);
        }
        
        Map<String, Object> model = new HashMap<>();
        model.put(InputSentence.SENTENCE_PARAMETERS, sentenceFilterSelector.getAllSentenceParameters());
        model.put(InputSentence.SENTENCE_PARAMETER, InputSentence.SENTENCE_PARAMETER);
        model.put(InputSentence.INPUT_PARAGRAPH, InputSentence.INPUT_PARAGRAPH);
        model.put(InputSentence.INPUT_SENTENCE, InputSentence.INPUT_SENTENCE);
        model.put(InputSentence.EXCEPTION, InputSentence.EXCEPTION);
        model.put(InputSentence.SENTENCES, sentencesList);
        model.put("exceptionOptions", exceptionOptions);
        return model;
    }
}
