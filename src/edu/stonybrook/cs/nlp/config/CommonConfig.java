package edu.stonybrook.cs.nlp.config;

import jiawei.kuang.common.util.StringUtil;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonConfig {
    @Bean
    public StringUtil stringUtil() {
        return new StringUtil();
    }
}
