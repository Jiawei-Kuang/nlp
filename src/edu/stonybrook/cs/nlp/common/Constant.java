package edu.stonybrook.cs.nlp.common;

/**
 * 
 * @author Jiawei Kuang
 * @version 1.0
 * @since Nov. 1, 2014
 */
public class Constant {
    public interface InputSentence {
        
        public final String INPUT_PARAGRAPH             = "inputParagraph";
        public final String INPUT_SENTENCE              = "inputSentence";
        
        public final String SENTENCE_PARAMETER          = "sentenceParameter";
        public final String SENTENCE_PARAMETERS         = "sentenceParameters";
        public final String EXCEPTION                   = "exception";
        public final String EXCEPTION_OPTIONS           = "exceptionOptions";
        
        public final String SENTENCES                   = "sentences";
        
        public interface Parameter {
            public final String STRICT                  = "Strict";
            public final String DEFEASIBLE              = "Defeasible";
        }
    }

}
