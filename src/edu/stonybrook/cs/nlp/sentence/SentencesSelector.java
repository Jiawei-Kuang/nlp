package edu.stonybrook.cs.nlp.sentence;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import edu.stonybrook.cs.nlp.common.Constant.InputSentence;

public class SentencesSelector {
    
    public List<Sentence> getSentences(HttpServletRequest request) {
        List<Sentence> sentences = new ArrayList<>();
        if (request.getParameterValues(InputSentence.SENTENCE_PARAMETER) == null) {
            return sentences;
        }
        
        //get all the parameters from request
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
                sentence.setSentence(inputSentences[i].trim());
                break;
            case InputSentence.Type.RULE :
                StringBuffer sb = new StringBuffer();
                sb.append("If ");
                sb.append(ifSentences[i].trim());
                sb.append(", then ");
                sb.append(thenSentences[i].trim());
                sb.append(".");
                sentence.setSentence(sb.toString());
                break;
            case InputSentence.Type.QUESTION :
                StringBuffer questionSentence = new StringBuffer();
                questionSentence.append(questionTypes[i] + " ");
                questionSentence.append(inputSentences[i].trim() + "?");
                sentence.setSentence(questionSentence.toString());
                break;
            }
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
