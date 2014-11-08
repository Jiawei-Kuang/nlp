package edu.stonybrook.cs.nlp.sentence;

import java.util.List;

public class Sentence {
    
    private Integer num;
    private String sentence;
    private String parameter;
    private List<String> exceptions;
    private String drs;
    private String fol;
    
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

}
