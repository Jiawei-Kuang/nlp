package edu.stonybrook.cs.nlp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import edu.stonybrook.cs.nlp.sentence.SentencesSelector;
import edu.stonybrook.cs.nlp.sentence.filter.SentenceFilter;
import edu.stonybrook.cs.nlp.sentence.filter.SentenceFilterSelector;
import edu.stonybrook.cs.nlp.sentence.parser.SentenceParser;
import edu.stonybrook.cs.nlp.sentence.parser.SentenceParserHandler;

@Configuration
public class SentenceConfig {
    @Bean
    public SentenceFilterSelector sentenceFilterSelector() {
        return new SentenceFilterSelector();
    }

    @Bean
    public SentenceFilter sentenceFilter(
            SentenceFilterSelector sentenceFilterSelector) {
        return new SentenceFilter(sentenceFilterSelector);
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
