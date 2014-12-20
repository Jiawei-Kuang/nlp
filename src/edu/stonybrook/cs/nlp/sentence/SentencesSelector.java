package edu.stonybrook.cs.nlp.sentence;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

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
            List<List<Integer>> exceptionsList = partitionExceptions(exceptions);
            for (int i = 0; i < setenceParameters.length; i++) {
                inputSentences[i] = inputSentences[i].trim();
                Sentence sentence = new Sentence(inputSentences[i], i + 1, 
                        setenceParameters[i], exceptionsList.get(i));
                sentences.add(sentence);
            }
        }
        return sentences;
    }
    
    /**
     * Get request from user and return list of sentences from the text area
     * @param request
     * @return List<String> sentences in text area
     */
    private List<Sentence> getParagraphSentences(HttpServletRequest request) {
        List<Sentence> sentences = new ArrayList<>();
        // Get input paragraph from request
        String inputParagraph = request.getParameter(InputSentence.INPUT_PARAGRAPH);
        Set<Character> set = new HashSet<>();
        set.add('.');
        set.add('?');
        set.add('!');
        List<String> strs = partitionString(inputParagraph, set);
        for (int i = 0; i < strs.size(); i++) {
            Sentence sentence = new Sentence(strs.get(i), i + 1);
            sentences.add(sentence);
        }
        return sentences;
    }
    
    /**
     * Get request from user, and partition exceptions to a list of
     * List<Integer> for each sentence.
     * 
     * @param exceptions
     * @return List<Integer> exception list
     */
    private List<List<Integer>> partitionExceptions(String[] exceptions) {
        List<List<Integer>> retList = new ArrayList<>();
        int len = exceptions.length;
        for (int i = 0; i < len; i++) {
            if (exceptions[i].equals("0")) {
                List<Integer> subList = new ArrayList<>();
                while (i + 1 < len && !exceptions[i + 1].equals("0")) {
                    subList.add(Integer.parseInt(exceptions[++i]));
                }
                retList.add(subList);
            }
        }
        return retList;
    }
    
    /**
     * This function partitions a String into several subStrings by some
     * characters in a set. e.g.
     * Partition "Who are you? I am Peter." into
     * ["Who are you?", "I am Peter."]
     * 
     * @param originalString
     * @param seperators is a set containing all the separator characters
     * @return List<String> by partitioning originalString by separators
     */
    private List<String> partitionString(String originalString, Set<Character> separators) {
        List<String> strs = new ArrayList<String>();
        char[] originalCharArr = originalString.toCharArray();
        int len = originalString.length();
        for (int i = 0; i < len; i++) {
            StringBuffer sb = new StringBuffer();
            while (i < len - 1 && !separators.contains(originalCharArr[i])) {
                sb.append(originalCharArr[i++]);
            }
            sb.append(originalCharArr[i]);
            String str = sb.toString().trim();
            if (!str.isEmpty()) {
                strs.add(str);
            }
        }
        return strs;
    }
}
