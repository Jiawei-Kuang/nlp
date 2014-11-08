package edu.stonybrook.cs.nlp;

import java.util.List;

public class Sentence {
	
	private Integer num;
	private String sentence;
	private String parameter;
	private List<String> excepts;
	private String drs;
	private String fol;
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(this.num + " :");
		sb.append(this.sentence);
		sb.append("(" + this.parameter + ")");
		for (String str : excepts) {
			sb.append(str + " ");
		}
		sb.append('\n');
		return sb.toString();
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
	public List<String> getExcepts() {
		return excepts;
	}
	public void setExcepts(List<String> excepts) {
		this.excepts = excepts;
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
