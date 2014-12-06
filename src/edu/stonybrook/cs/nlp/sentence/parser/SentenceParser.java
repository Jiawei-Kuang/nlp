package edu.stonybrook.cs.nlp.sentence.parser;

import ch.uzh.ifi.attempto.ape.ACEParserException;
import ch.uzh.ifi.attempto.ape.APELocal;
import ch.uzh.ifi.attempto.ape.OutputType;

/**
 * By now, we use Attempto APE to test the UI In the future, we will use our
 * parser
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

    public String parseToDRS(String text) throws ACEParserException {
        APELocal apeLocal = getApeLocal();
        apeLocal.setGuessingEnabled(true);
        String drs = apeLocal.getSoloOutput(text, OutputType.DRS);
        return drs;
    }

    public String parseToFOL(String text) throws ACEParserException {
        APELocal apeLocal = getApeLocal();
        apeLocal.setGuessingEnabled(true);
        String fol = apeLocal.getSoloOutput(text, OutputType.FOL);
        return fol;
    }
}
