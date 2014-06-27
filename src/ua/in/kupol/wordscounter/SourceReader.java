package ua.in.kupol.wordscounter;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by kpl on 27.06.2014.
 */
public class SourceReader {
    static Logger logger = Logger.getLogger(WordsCounter.class);
//    public SourceReader(){
//
//    }

    public String readFromFile(){
        WordsCounterGetProperties wordsCounterGetProperties = new WordsCounterGetProperties();
        InputStream input = null;
        String noTextSourceFile = "No Source File";

        try {
            byte[] textSources = Files.readAllBytes(Paths.get(wordsCounterGetProperties.getPathToTextFile()));
            return new String(textSources);
        } catch (IOException ex) {
//            ex.printStackTrace();
            logger.error("Sorry, unable to find " + Main.PROPERTIES_FILE, ex);
        } finally{
            if(input!=null){
                try {
                    input.close();
                } catch (IOException e) {
//                    e.printStackTrace();
                    logger.error("Sorry, can't close file" + Main.PROPERTIES_FILE, e);
                }
            }
        }
        return noTextSourceFile;
    }
}
