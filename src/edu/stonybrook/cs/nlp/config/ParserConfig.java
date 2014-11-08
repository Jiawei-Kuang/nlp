package edu.stonybrook.cs.nlp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import edu.stonybrook.cs.nlp.parser.ParserHandler;

@Configuration
public class ParserConfig {
    
    @Bean
    public ParserHandler parserHandler() {
        return new ParserHandler();
    }

}
