package semanticprocessing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Contains the main search function.
 * @author Hussam, Isiah, Frank, Moody, Vera
 */
public final class Search implements Serializable {

    /** The cache to search. May be edited by external classes. */
    public Cache cache;
    /** The search input. */
    private String text;
    /** Ignored words in search input. */
    private String ignoredWords;
    /** Where search results are stored. */
    private ArrayList<Result> results;
    /** Size factor for score, to prevent loss of precision. */
    private static final int SIZE_FACTOR = 1000;

    /**
     * Construct a new Search object with the given parameters.
     * @param memberCache The cache to search.
     * @param query The text to search for in cache.
     * @param ignoredWordsString Words to ignore from text.
     */
    public Search(final Cache memberCache, final String query,
            final String ignoredWordsString) {
        this.cache = memberCache;
        this.text = query;
        this.ignoredWords = ignoredWordsString;
    }

    /**
     * Construct a new Search object with the given parameters. The result
     * parameter is passed to facilitate file storage.
     * @param memberCache The memberCache to search.
     * @param query The query to search for in memberCache.
     * @param ignoredWordsString Words to ignore from query.
     * @param oldSearchResults The results array list. Used to store results
     * in this search.
     */
    public Search(final Cache memberCache, final String query,
            final String ignoredWordsString,
            final ArrayList<Result> oldSearchResults) {
        this.cache = memberCache;
        this.text = query;
        this.ignoredWords = ignoredWordsString;
        this.results = (ArrayList<Result>) oldSearchResults.clone();
    }

    /**
     * Returns a HashMap that has keywords for keys and their number of times
     * they occur for values.
     * @return a HashMap that has the keywords for keys and they number of
     * times they occur for values.
     */
    private HashMap<String, Integer> getInputKeywords() {
        HashMap<String, Integer> wordMap = new HashMap<String, Integer>();
        String paragraphWithoutPunc = deletePunc(text);

        if (text.matches("^\\s*$")) {
            return wordMap;
        }

        String[] paraWithoutPunc = paragraphWithoutPunc.split("\\s");

        // For every words in contents, if it is in the map then update the
        // value else add it to the map.
        for (String word : paraWithoutPunc) {
            if (ignoredWords.contains(word)) {
                // If the word is ignored skip it.
                continue;
            }
            if (wordMap.containsKey(word)) {
                wordMap.put(word, wordMap.get(word) + 1);
            } else {
                wordMap.put(word, 1);
            }
        }

        return wordMap;
    }

    /**
     * Returns a string free of punctuation marks, multi-tabs and apostrophes.
     * @param string that has punctuation marks, multi-tabs and apostrophes
     * that are to be deleted
     * @return a string free of punctuation marks, multi-tabs and apostrophes
     */
    private String deletePunc(final String string) {
        String str = string.replaceAll("\\W+\\s", " ");
        str = str.replaceAll("('s)|(s')", " ");
        str = str.replaceAll("\\s+", " ");
        return str;
    }

    /**
     * Returns an int that is the score of the facultyMember with respect to
     * the given keywords.
     * @param member A FacultyMember that is being evaluated
     * @param keywords A HashMap with keywords as keys and their importance as
     * values
     * @return The score of the facultyMember with respect to
     * the given keywords
     */
    private double getMemberScore(final FacultyMember member,
            final HashMap<String, Integer> keywords) {
        double absoluteScore = 0;
        for (String s : keywords.keySet()) {
            absoluteScore += member.getNumberOfOccurrences(s) * keywords.get(s);
        }
        // Multiple by constant to enlarge result
        return absoluteScore * SIZE_FACTOR / member.getContentLength();
    }

    /**
     * Searches the given Cache for the given text, ignoring the given
     * ignored words. Repeated words in text are considered more important.
     */
    public void search() {
        // The input keywords and the number of times they show up. Does not
        // include ignored words.
        HashMap<String, Integer> keywords = getInputKeywords();
        ArrayList<Result> resultsArrayList = new ArrayList<Result>();
        if (cache.isEmpty()) {
            results = resultsArrayList;
            return;
        }
        PriorityQueue<Result> theResults = new PriorityQueue<Result>(
                cache.size(), Collections.reverseOrder());

        for (FacultyMember member : cache) {
            Result memberResult =
                    new Result(member, getMemberScore(member, keywords));
            theResults.add(memberResult);
        }

        for (Result result : theResults) {
            resultsArrayList.add(result);
        }
        results = resultsArrayList;
    }

    /**
     * Get the results of the most recent search. If no results are found,
     * performs a new search.
     * @return An array list of result object each containing a FacultyMember
     * and a score for that FacultyMember object.
     */
    public ArrayList<Result> getResults() {
        if (results == null) {
            search();
        }
        // Result objects are immutable so this is enough
        return (ArrayList<Result>) results.clone();
    }

    /**
     * Gets the problem statement in this object.
     * @return The problem statement in this object.
     */
    public String getProblemStatement() {
        return this.text;
    }

    /**
     * Gets the ignored words string in this object.
     * @return The ignored words string in this object.
     */
    public String getIgnoredWordsString() {
        return this.ignoredWords;
    }
}
