package edu.stonybrook.cs.nlp.sentence;

import java.util.ArrayList;
import java.util.List;

import edu.stonybrook.cs.nlp.common.Constant.InputSentence;

/**
 * This class is used to store the content of one sentence
 * with its sequence number, parameter, exception, drs and 
 * fol result.
 * 
 * @author Jiawei Kuang
 * @version 1.0
 * @since Nov. 8, 2014
 */

public class Sentence {
    private Integer num;
    private String sentence;
    private String parameter;
    // This should change to List<Integer> later
    private List<String> exceptions;
    private String drs;
    private String fol;
    private boolean drsParseSuccess;
    private boolean folParseSuccess;
    
    public Sentence() {
    }
    
    public Sentence(String sentence, int num) {
        init(sentence, num);
        this.parameter = InputSentence.Parameter.STRICT;
        this.exceptions = new ArrayList<>();
    }
    
    public Sentence(String sentence, int num, String parameter, List<String> exceptions) {
        init(sentence, num);
        this.parameter = parameter;
        this.exceptions = exceptions;
    }
    
    private void init(String sentence, int num) {
        this.sentence = sentence;
        this.num = num;
    }
    
    public Integer getNum() {
        return num;
    }
    
    public void setNum(Integer num) {
        this.num = num;
    }
    
    public String getSentence() {
        return sentence;
    }
    
    public void setSentence(String sentence) {
        this.sentence = sentence;
    }
    
    public String getParameter() {
        return parameter;
    }
    
    public void setParameter(String parameter) {
        this.parameter = parameter;
    }
    
    public List<String> getExceptions() {
        return exceptions;
    }
    
    public void setExceptions(List<String> excepts) {
        this.exceptions = excepts;
    }
    
    public String getDrs() {
        return drs;
    }
    
    public void setDrs(String drs) {
        this.drs = drs;
    }
    
    public String getFol() {
        return fol;
    }
    
    public void setFol(String fol) {
        this.fol = fol;
    }
    
    public boolean isDrsParseSuccess() {
        return drsParseSuccess;
    }
    
    public void setDrsParseSuccess(boolean drsParseSuccess) {
        this.drsParseSuccess = drsParseSuccess;
    }
    
    public boolean isFolParseSuccess() {
        return folParseSuccess;
    }
    
    public void setFolParseSuccess(boolean folParseSuccess) {
        this.folParseSuccess = folParseSuccess;
    }
}
