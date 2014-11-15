package edu.stonybrook.cs.nlp.sentence.parser;

import ch.uzh.ifi.attempto.ape.ACEParserException;
import ch.uzh.ifi.attempto.ape.APELocal;
import ch.uzh.ifi.attempto.ape.OutputType;
import edu.stonybrook.cs.nlp.exception.SentenceInvalidException;

/**
 * By now, we use Attempto APE to test the UI
 * In the future, we will use our parser
 * 
 * @author Jiawei Kuang
 * @version 1.0
 * @since Nov. 8, 2014
 */

public class SentenceParser {

    private APELocal getApeLocal() {
        APELocal.init("C:\\ape-6.7-131003\\ape.exe", true);
        return APELocal.getInstance();
    }

    public String parseToDRS(String text) throws SentenceInvalidException {
        try {
            APELocal apeLocal = getApeLocal();
            apeLocal.setGuessingEnabled(true);
            String drs = apeLocal.getSoloOutput(text, OutputType.DRS);
            return drs;
        } catch (ACEParserException e) {
            throw new SentenceInvalidException("InputSentence cannot be parsed to DRS");
        }
    }

    public String parseToFOL(String text) throws SentenceInvalidException {
        try {
            APELocal apeLocal = getApeLocal();
            apeLocal.setGuessingEnabled(true);
            String fol = apeLocal.getSoloOutput(text, OutputType.FOL);
            return fol;
        } catch (ACEParserException e) {
            throw new SentenceInvalidException(
                    "Input sentence cannot be parsed to FOL");
        }
    }
}
