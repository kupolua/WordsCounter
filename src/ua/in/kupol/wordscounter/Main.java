package ua.in.kupol.wordscounter;

/**
 * Created by kpl on 27.06.2014.
 *
 */
public class Main {
    public static final String PROPERTIES_FILE  = "config.properties";

    public static void main(String[] args) {

        Thread file1 = new Thread(new Runnable() {
            @Override
            public void run() {
                WordsCounter wordsCounter = new WordsCounter();
                wordsCounter.textFileReader("1");

            }
        });
        file1.setName("file1");
        file1.start();
        Thread file2 = new Thread(new Runnable() {
            @Override
            public void run() {
                WordsCounter wordsCounter = new WordsCounter();
                wordsCounter.textFileReader("2");

            }
        });
        file2.setName("file2");
        file2.start();

        Thread file3 = new Thread(new Runnable() {
            @Override
            public void run() {
                WordsCounter wordsCounter = new WordsCounter();
                wordsCounter.textFileReader("3");

            }
        });
        file3.setName("file3");
        file3.start();




    }
}
