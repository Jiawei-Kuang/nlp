package edu.stonybrook.cs.nlp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import edu.stonybrook.cs.nlp.sentence.SentencesSelector;
import edu.stonybrook.cs.nlp.sentence.filter.SentenceFilter;
import edu.stonybrook.cs.nlp.sentence.filter.SentenceFilterSelector;
import edu.stonybrook.cs.nlp.sentence.parser.SentenceParser;
import edu.stonybrook.cs.nlp.sentence.parser.SentenceParserHandler;

/**
 * 
 * @author Jiawei Kuang
 * @version 1.0
 * @since Nov. 8, 2014
 */

@Configuration
public class SentenceConfig {
    @Bean
    public SentenceFilterSelector sentenceFilterSelector() {
        return new SentenceFilterSelector();
    }

    @Bean
    public SentenceFilter sentenceFilter() {
        return new SentenceFilter();
    }
    
    @Bean
    public SentencesSelector sentencesSelector() {
        return new SentencesSelector();
    }
    
    @Bean
    public SentenceParser sentenceParser() {
        return SentenceParser.getSentenceParser();
    }
    
    @Bean
    public SentenceParserHandler sentenceParserHandler() {
        return new SentenceParserHandler();
    }
}
