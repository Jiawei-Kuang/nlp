package edu.stonybrook.cs.nlp.parser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import edu.stonybrook.cs.nlp.common.Constant.InputSentence;
import edu.stonybrook.cs.nlp.sentence.Sentence;
import edu.stonybrook.cs.nlp.sentence.SentencesSelector;
import edu.stonybrook.cs.nlp.sentence.filter.SentenceFilter;
import edu.stonybrook.cs.nlp.sentence.parser.SentenceParserHandler;

public class ParserHandler {
    
    @Autowired
    private SentenceFilter sentenceFilter;
    
    @Autowired
    private SentencesSelector sentencesSelector;
    
    @Autowired
    private SentenceParserHandler sentenceParserHandler;
    
    public Map<String, Object> getModel(HttpServletRequest request) {
        Map<String, Object> model = new HashMap<>();
        model.put(InputSentence.SENTENCE_PARAMETERS, sentenceFilter.getAllSentenceParameters());
        model.put(InputSentence.SENTENCE_PARAMETER, InputSentence.SENTENCE_PARAMETER);
        model.put(InputSentence.SENTENCE_TYPES, sentenceFilter.getAllSentenceTypes());
        model.put(InputSentence.SENTENCE_TYPE, InputSentence.SENTENCE_TYPE);
        model.put(InputSentence.QUESTION_TYPES, sentenceFilter.getAllInterrogatives());
        model.put(InputSentence.QUESTION_TYPE, InputSentence.QUESTION_TYPE);
        List<Sentence> sentencesList = sentencesSelector.getSentences(request);
        model.put("sentences", sentencesList);
        
        for (int i = 0; i < sentencesList.size(); i++) {
            Sentence sentence = sentencesList.get(i);
            sentenceParserHandler.parse(sentence);
        }
        
        return model;
    }
}
