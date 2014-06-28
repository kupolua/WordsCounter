package ua.in.kupol.wordscounter;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by kpl on 27.06.2014.
 */
public class WordsCounterGetProperties {
    static Logger logger = Logger.getLogger(WordsCounterGetProperties.class);
    Properties wordsCounterProperties = new Properties();

    public WordsCounterGetProperties(){
        InputStream input = null;
        try {
            input = Main.class.getClassLoader().getResourceAsStream(Main.PROPERTIES_FILE);
            wordsCounterProperties.load(input);
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
    }
    public String getPathToTextFile(String numberOfFileName) {
        return wordsCounterProperties.getProperty("pathToTextFile")
               + wordsCounterProperties.getProperty(numberOfFileName + "textFileName");
    }
    public String getReGex () {
        return wordsCounterProperties.getProperty("regexMask");
    }
    public String getReGexReplacement () {
        return wordsCounterProperties.getProperty("regexReplacement");
    }
}
