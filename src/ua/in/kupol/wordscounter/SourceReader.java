package ua.in.kupol.wordscounter;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by kpl on 27.06.2014.
 */
public class SourceReader {
//    public SourceReader(){
//
//    }

    public String readFromFile(){
        WordsCounterGetProperties wordsCounterGetProperties = new WordsCounterGetProperties();
        InputStream input = null;
        String noTextSourceFile = "No Source File";

        try {
            byte[] textSources = Files.readAllBytes(Paths.get(wordsCounterGetProperties.getPathToTextFile()));
            return new String(textSources, "utf-8");
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally{
            if(input!=null){
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return noTextSourceFile;
    }
}