package edu.stonybrook.cs.nlp.common;

/**
 * 
 * @author Jiawei Kuang
 * @version 1.0
 * @since Nov. 1, 2014
 */
public class Constant {
    public interface InputSentence {
        
        public final String INPUT_SENTENCE              = "inputSentence";
        public final String IF_SENTENCE                 = "ifSentence";
        public final String THEN_SENTENCE               = "thenSentence";
        
        public final String SENTENCE_PARAMETER          = "sentenceParameter";
        public final String SENTENCE_PARAMETERS         = "sentenceParameters";
        public final String SENTENCE_TYPE               = "sentenceType";
        public final String SENTENCE_TYPES              = "sentenceTypes";
        public final String QUESTION_TYPE               = "questionType";
        public final String QUESTION_TYPES              = "questionTypes";
        public final String EXCEPTION                   = "except";
        
        public interface Interrogative {
            public final String WHAT                    = "What";
            public final String WHERE                   = "Where";
            public final String WHEN                    = "When";
        }
        
        public interface Type {
            public final String SENTENCE                = "Sentence";
            public final String RULE                    = "Rule";
            public final String QUESTION                = "Question";
        }
        
        public interface Parameter {
            public final String STRICT                  = "Strict";
            public final String DEFEASIBLE              = "Defeasible";
        }
    }
}
