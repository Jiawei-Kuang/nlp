package edu.stonybrook.cs.nlp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.stonybrook.cs.nlp.common.Constant.InputSentence;
import edu.stonybrook.cs.nlp.parser.filter.SentenceParserFilter;
import edu.stonybrook.cs.nlp.sentences.SentencesSelector;

/*
 * author: Jiawei Kuang
 * 
 */

@Controller
public class HomeController {

	@Autowired
	private SentenceParserFilter sentenceParserFilter;
	
	@Autowired
	private SentencesSelector sentencesSelector;
	
	@Autowired
	private SentenceParserHandler sentenceParserHandler;
	
	public HomeController() {
	}

	@RequestMapping("/parser")
	public ModelAndView sentenceParser(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<>();
		model.put(InputSentence.SENTENCE_PARAMETERS, sentenceParserFilter.getAllSentenceParameters());
		model.put(InputSentence.SENTENCE_PARAMETER, InputSentence.SENTENCE_PARAMETER);
		model.put(InputSentence.SENTENCE_TYPES, sentenceParserFilter.getAllSentenceTypes());
		model.put(InputSentence.SENTENCE_TYPE, InputSentence.SENTENCE_TYPE);
		model.put(InputSentence.QUESTION_TYPES, sentenceParserFilter.getAllInterrogatives());
		model.put(InputSentence.QUESTION_TYPE, InputSentence.QUESTION_TYPE);
		List<Sentence> sentencesList = sentencesSelector.getSentences(request);
		model.put("sentences", sentencesList);
		
		for (int i = 0; i < sentencesList.size(); i++) {
			Sentence sentence = sentencesList.get(i);
			sentenceParserHandler.parse(sentence);
		}
		
		return new ModelAndView("parser", "model", model);
	}

	@RequestMapping("/home")
	public ModelAndView homePage() {
		return new ModelAndView("home", "message", "");
	}
}