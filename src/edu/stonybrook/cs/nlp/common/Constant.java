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
        public final String IF_SENTENCE                 = "ifSentence";
        public final String THEN_SENTENCE               = "thenSentence";
        public final String IF                          = "If";
        public final String THEN                        = "Then";
        
        public final String SENTENCE_PARAMETER          = "sentenceParameter";
        public final String SENTENCE_PARAMETERS         = "sentenceParameters";
        public final String SENTENCE_TYPE               = "sentenceType";
        public final String SENTENCE_TYPES              = "sentenceTypes";
        public final String QUESTION_TYPE               = "questionType";
        public final String QUESTION_TYPES              = "questionTypes";
        public final String EXCEPTION                   = "exception";
        
        public final String SENTENCES                   = "sentences";
        public final String IS_VALID_SENTENCE           = "isValidSentence";
        public final String EXCEPTION_MESSAGE           = "exceptionMessage";
        
        public interface Interrogative {
            public final String WHAT                    = "What";
            public final String WHERE                   = "Where";
            public final String WHEN                    = "When";
        }
        
        public interface Type {
            public final String SENTENCE                = "Sentence";
            public final String RULE                    = "Rule";
            public final String QUESTION                = "Question";
            public final String CANCEL                  = "Cancel";
        }
        
        public interface Parameter {
            public final String STRICT                  = "Strict";
            public final String DEFEASIBLE              = "Defeasible";
        }
    }

}
