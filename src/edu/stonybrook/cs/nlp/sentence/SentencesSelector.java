package edu.stonybrook.cs.nlp.sentence;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import jiawei.kuang.common.util.NumUtil;
import jiawei.kuang.common.util.StringUtil;

import org.springframework.beans.factory.annotation.Autowired;

import edu.stonybrook.cs.nlp.common.Constant.InputSentence;
import edu.stonybrook.cs.nlp.exception.SentenceInvalidException;

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
    private NumUtil numUtil;
    
    @Autowired
    private StringUtil stringUtil;
    
    /**
     * This method read all the informations got from http request,
     * then process them and return a list a sentence object.
     * 
     * @param request
     * @return List<Sentence>
     */
    public List<Sentence> getSentences(HttpServletRequest request) 
            throws SentenceInvalidException{
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
//                if (inputSentences[i].isEmpty()) {
//                    throw new SentenceInvalidException(
//                            emptyInputExceptionMessage(i + 1));
//                }
                inputSentences[i] = inputSentences[i].trim();
                Sentence sentence = new Sentence(inputSentences[i], i + 1, 
                        setenceParameters[i], exceptionsList.get(i));
                sentences.add(sentence);
            }
        }
        return sentences;
        
        /*
        List<Sentence> sentences = new ArrayList<>();
        if (request.getParameterValues(InputSentence.SENTENCE_PARAMETER) == null) {
            return sentences;
        }
        
        String[] inputSentences         = request.getParameterValues(InputSentence.INPUT_SENTENCE);
        String[] ifSentences            = request.getParameterValues(InputSentence.IF_SENTENCE);
        String[] thenSentences          = request.getParameterValues(InputSentence.THEN_SENTENCE);
        String[] setenceParameters      = request.getParameterValues(InputSentence.SENTENCE_PARAMETER);
        String[] sentenceTypes          = request.getParameterValues(InputSentence.SENTENCE_TYPE);
        String[] questionTypes          = request.getParameterValues(InputSentence.QUESTION_TYPE);
        String[] exceptions             = request.getParameterValues(InputSentence.EXCEPTION);
        List<List<String>> exceptionsList = partitionExceptions(exceptions);
        
        int numOfSentences = setenceParameters.length;
        for (int i = 0; i < numOfSentences; i++) {
            Sentence sentence = new Sentence();
            sentence.setNum(i + 1);
            sentence.setParameter(setenceParameters[i]);
            sentence.setExceptions(exceptionsList.get(i));
            switch (sentenceTypes[i]) {
            case InputSentence.Type.SENTENCE :
                if (inputSentences[i].isEmpty()) {
                    throw new SentenceInvalidException(
                            emptyInputExceptionMessage(i + 1));
                }
                sentence.setSentence(inputSentences[i].trim());
                break;
            case InputSentence.Type.RULE :
                if (ifSentences[i].isEmpty() || thenSentences[i].isEmpty()) {
                    throw new SentenceInvalidException(
                            emptyInputExceptionMessage(i + 1));
                }
                StringBuffer sb = new StringBuffer();
                sb.append("If ");
                sb.append(ifSentences[i].trim());
                sb.append(", then ");
                sb.append(thenSentences[i].trim());
                sb.append(".");
                sentence.setSentence(sb.toString());
                break;
            case InputSentence.Type.QUESTION :
                if (inputSentences[i].isEmpty()) {
                    throw new SentenceInvalidException(
                            emptyInputExceptionMessage(i + 1));
                }
                StringBuffer questionSentence = new StringBuffer();
                questionSentence.append(questionTypes[i] + " ");
                questionSentence.append(inputSentences[i].trim() + "?");
                sentence.setSentence(questionSentence.toString());
                break;
            }
            sentences.add(sentence);
        }
        
        return sentences;
        */
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
    
    /**
     * 
     * @param num, the sequence number of input sentence
     * @return the ordinal number of input number
     */
//    private String emptyInputExceptionMessage(int num) {
//        Formatter formatter = new Formatter();
//        formatter.format("The %s input sentence is not completed", 
//                numUtil.convertNumToOrdinal(num));
//        String ret = formatter.toString();
//        formatter.close();
//        return ret;
//    }
    
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
