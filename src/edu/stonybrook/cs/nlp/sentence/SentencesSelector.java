package edu.stonybrook.cs.nlp.sentence;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import jiawei.kuang.common.util.StringUtil;

import org.springframework.beans.factory.annotation.Autowired;

import edu.stonybrook.cs.nlp.common.Constant.InputSentence;

/**
 * This class is used to get and clean the informations
 * got from http request.
 * 
 * @author Jiawei Kuang
 * @version 1.0
 * @since Nov. 8, 2014
 */

public class SentencesSelector {
    
    @Autowired
    private StringUtil stringUtil;
    
    /**
     * This method read all the informations got from http request,
     * then process them and return a list a sentence object.
     * 
     * @param request
     * @return List<Sentence>
     */
    public List<Sentence> getSentences(HttpServletRequest request) {
        List<Sentence> sentences = new ArrayList<>();
        String submit = request.getParameter("submit");
        if (submit == null) {
            return sentences;
        } else if (submit.equals("sentences")) {
            sentences = getParagraphSentences(request);
        } else if (submit.equals("update")) {
            String[] inputSentences         = request.getParameterValues(InputSentence.INPUT_SENTENCE);
            String[] setenceParameters      = request.getParameterValues(InputSentence.SENTENCE_PARAMETER);
            String[] exceptions             = request.getParameterValues(InputSentence.EXCEPTION);
            List<List<String>> exceptionsList = partitionExceptions(exceptions);
            int numOfSentences = setenceParameters.length;
            for (int i = 0; i < numOfSentences; i++) {
                inputSentences[i] = inputSentences[i].trim();
                Sentence sentence = new Sentence(inputSentences[i], i + 1, 
                        setenceParameters[i], exceptionsList.get(i));
                sentences.add(sentence);
            }
        }
        return sentences;
    }
    
    private List<Sentence> getParagraphSentences(HttpServletRequest request) {
        List<Sentence> sentences = new ArrayList<>();
        // Get input paragraph from request
        String inputParagraph = request.getParameter(InputSentence.INPUT_PARAGRAPH);
        Set<Character> set = new HashSet<>();
        set.add('.');
        set.add('?');
        set.add('!');
        List<String> strs = stringUtil.partitionString(inputParagraph, set);
        for (int i = 0; i < strs.size(); i++) {
            Sentence sentence = new Sentence(strs.get(i), i + 1);
            sentences.add(sentence);
        }
        return sentences;
    }
    
    private List<List<String>> partitionExceptions(String[] exceptions) {
        List<List<String>> retList = new ArrayList<List<String>>();
        int len = exceptions.length;
        for (int i = 0; i< len; i++) {
            if (exceptions[i].equals("0")) {
                List<String> subList = new ArrayList<>();
                while (i + 1 < len && !exceptions[i + 1].equals("0")) {
                    subList.add(exceptions[++i]);
                }
                retList.add(subList);
            }
        }
        return retList;
    }
}
