package edu.stonybrook.cs.nlp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	// @Autowired
	// private SentenceParserFilter sentenceParserFilter;

	@RequestMapping("/parser")
	public ModelAndView sentenceParser(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<>();

		SentenceParser parser = new SentenceParser();
		String[] inputSentences = request.getParameterValues("inputSentence");
		String[] exceptions = request.getParameterValues("exception");
		String[] except = request.getParameterValues("except");
		if (except != null) {
			System.out.println(except.length);
			for (String str : except) {
				System.out.println(str);
			}
		}
		List<Sentence> sentencesList = new ArrayList<>();
		model.put("sentences", sentencesList);
		if (inputSentences == null || inputSentences.length == 0) {
			return new ModelAndView("parser", "model", model);
		}
		for (int i = 0; i < inputSentences.length; i++) {
			Sentence sentence = new Sentence();
			sentence.setSentence(inputSentences[i]);
			sentence.setException(exceptions[i]);
			sentence.setNum(i + 1);
			SentenceParserHandler.parse(sentence, parser);
			sentencesList.add(sentence);
		}

		return new ModelAndView("parser", "model", model);
	}

	@RequestMapping("/home")
	public ModelAndView homePage() {
		return new ModelAndView("home", "message", "");
	}
}