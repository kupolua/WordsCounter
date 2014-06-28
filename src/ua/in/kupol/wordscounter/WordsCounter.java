package ua.in.kupol.wordscounter;

import org.apache.log4j.Logger;

import java.util.*;

/**
 * Created by kpl on 27.06.2014.
 *
 */
public class WordsCounter {

    static Logger logger = Logger.getLogger(WordsCounter.class);
    WordsCounterGetProperties wordsCounterGetProperties = new WordsCounterGetProperties();

    public void textFileReader(String numberOfFileName){

        logger.info("Start WordsCounter programm");

        SourceReader sourceReader = new SourceReader();
//        String textSource = sourceReader.readFromFile().replaceAll(wordsCounterGetProperties.getReGex(), wordsCounterGetProperties.getReGexReplacement());
        String textSource = sourceReader.readFromFile(numberOfFileName).replaceAll("[^aA-zZ ’]", " ");

        logger.info("Text after regex, before split(space) :  " + textSource);

        List<String> wordsList = new ArrayList<String>(Arrays.asList(textSource.split(" ")));
        Map<String, Integer> words = new HashMap<String, Integer>();
        int countWord;
        for(String word : wordsList) {
            if (words.get(word.toLowerCase()) == null) {
                words.put(word.toLowerCase(), 1);
            } else {
                countWord = words.get(word.toLowerCase());
                words.put(word.toLowerCase(), countWord + 1);
             }
        }
        Map<String, Integer> wordsSortByFound = sortByComparator(words);
        logger.info("List words: " + wordsSortByFound);
    }
    private static Map sortByComparator(Map unsortMap) {

        List list = new LinkedList(unsortMap.entrySet());

        // sort list based on comparator
        Collections.sort(list, new Comparator() {
            public int compare(Object o1, Object o2) {
                return ((Comparable) ((Map.Entry) (o2)).getValue())
                        .compareTo(((Map.Entry) (o1)).getValue());
            }
        });

        // put sorted list into map again
        //LinkedHashMap make sure order in which keys were inserted
        Map sortedMap = new LinkedHashMap();
        for (Iterator it = list.iterator(); it.hasNext();) {
            Map.Entry entry = (Map.Entry) it.next();
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }
}
