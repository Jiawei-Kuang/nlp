package edu.stonybrook.cs.nlp;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.stonybrook.cs.nlp.parser.ParserHandler;

/*
 * author: Jiawei Kuang
 * 
 */

@Controller
public class HomeController {

    @Autowired
    private ParserHandler parserHandler;

    @RequestMapping("/parser")
    public ModelAndView sentenceParser(HttpServletRequest request) {
        Map<String, Object> model = parserHandler.getModel(request);
        return new ModelAndView("parser", "model", model);
    }

    @RequestMapping("/home")
    public ModelAndView homePage() {
        return new ModelAndView("home", "message", "");
    }
}