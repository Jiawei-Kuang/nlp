package edu.stonybrook.cs.nlp;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/*
 * author: Jiawei Kuang
 * 
 */

@Controller
public class HomeController {
	@RequestMapping("/parser")
	public ModelAndView sentenceParser(HttpServletRequest request) {
		SentenceParser parser = new SentenceParser();
		
		String[] inputSentences = request.getParameterValues("inputSentence");
		String[] exceptions = request.getParameterValues("exception");
		List<Sentence> sentencesList = new ArrayList<>();
		if (inputSentences == null || inputSentences.length == 0) {
			return new ModelAndView("parser", "sentences", sentencesList);
		}
		for(int i = 0; i < inputSentences.length; i++) {
			Sentence sentence = new Sentence();
			sentence.setSentence(inputSentences[i]);
			sentence.setException(exceptions[i]);
			sentence.setNum(i + 1);
			SentenceParserHandler.parse(sentence, parser);
			sentencesList.add(sentence);
		}

		return new ModelAndView("parser", "sentences", sentencesList);
	}
	
	@RequestMapping("/home")
	public ModelAndView homePage() {
		return new ModelAndView("home", "message", "");
	}
}