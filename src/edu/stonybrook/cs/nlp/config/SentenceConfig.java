package edu.stonybrook.cs.nlp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import edu.stonybrook.cs.nlp.SentenceParser;
import edu.stonybrook.cs.nlp.SentenceParserHandler;
import edu.stonybrook.cs.nlp.parser.filter.SentenceParserFilter;
import edu.stonybrook.cs.nlp.parser.filter.SentenceParserFilterSelector;
import edu.stonybrook.cs.nlp.sentences.SentencesSelector;

@Configuration
public class SentenceConfig {
	@Bean
	public SentenceParserFilterSelector sentenceParserFilterSelector() {
		return new SentenceParserFilterSelector();
	}

	@Bean
	public SentenceParserFilter sentenceParserFilter(
			SentenceParserFilterSelector sentenceParserFilterSelector) {
		return new SentenceParserFilter(sentenceParserFilterSelector);
	}
	
	@Bean
	public SentencesSelector sentencesSelector() {
		return new SentencesSelector();
	}
	
	@Bean
	public SentenceParser sentenceParser() {
		return new SentenceParser();
	}
	
	@Bean
	public SentenceParserHandler sentenceParserHandler() {
		return new SentenceParserHandler();
	}
}
