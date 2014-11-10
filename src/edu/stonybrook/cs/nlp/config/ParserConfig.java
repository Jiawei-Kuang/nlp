package edu.stonybrook.cs.nlp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import edu.stonybrook.cs.nlp.parser.ParserHandler;

/**
 * 
 * @author Jiawei Kuang
 * @version 1.0
 * @since Nov. 8, 2014
 */

@Configuration
public class ParserConfig {
    
    @Bean
    public ParserHandler parserHandler() {
        return new ParserHandler();
    }

}
