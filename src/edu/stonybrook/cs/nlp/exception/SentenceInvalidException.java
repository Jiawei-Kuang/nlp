package edu.stonybrook.cs.nlp.exception;

/**
 * @author Jiawei Kuang
 * @version 1.0
 * @since Nov. 8, 2014
*/
public class SentenceInvalidException extends Exception {
    
    private static final long serialVersionUID = -7412930269629231915L;
    
    public SentenceInvalidException(String message) {
        super(message);
    }

}
