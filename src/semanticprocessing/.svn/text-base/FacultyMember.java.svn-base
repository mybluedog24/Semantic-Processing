package semanticprocessing;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Represents a single faculty member.
 * @author Hussam and Frank
 */
public class FacultyMember implements Serializable {

    /** The URL of the main Page of this faculty member. */
    private URL homePageUrl;
    /** All words that appear on all members Pages are stored as keys, and
     * their values is their respective number of occurrences. */
    private Map<String, Integer> words;
    /** The maximum number of links to follow. */
    private static final int MAXIMUM_NUMBER_OF_LINKS = 50;
    /** The length of all pages that belong to this member combined. */
    private int contentLength = 0;

    /**
     * Constructs a new instance of FacultyMember and index all of this member's
     * pages (up to a maximum number set in the class to limit memory
     * consumption and time spent contacting server).
     * @param url The URL of the home page of this faculty member.
     * @throws IOException When the member's home Page cannot be accessed.
     * @throws NotAnHtmlUrlException If the given URL is not an HTML page.
     */
    FacultyMember(final URL url) throws IOException, NotAnHtmlUrlException {
        Page homePage = new Page(url);
        homePageUrl = homePage.getURL();
        String allContentCombined = getSuperString(homePage);
        words = this.getWords(allContentCombined);
    }

    /**
     * Retrieves all the HTML-free content from all pages that reside in the
     * same directory. Does a breadth first search. Visits  up to
     * MAXIMUM_NUMBER_OF_PAGES links.
     * @param link The URL of the page to begin with.
     * @return A String that contains all the HTML-free content of all the web
     * pages linked from this one that are in this member's directory.
     * @throws IOException if the URL given is unreachable.
     * @throws NotAnHtmlUrlException if the link given doesn't point to a page.
     */
    public final String getSuperString(final Page home) throws IOException,
            NotAnHtmlUrlException {
        String superString = "";

        Queue<URL> pendingUrls = new LinkedList<URL>();
        ArrayList<URL> visitedUrls = new ArrayList<URL>();

        visitedUrls.add(home.getURL());
        superString += home.getContent() + "\n";
        pendingUrls.addAll(getUrlsWithinMembersDirectory(home.getUrls()));

        while (!pendingUrls.isEmpty()
                && visitedUrls.size() <= MAXIMUM_NUMBER_OF_LINKS) {
            URL url = pendingUrls.remove();

            // Process only the links that have not already been visited
            if (!visitedUrls.contains(url)) {
                // Link has now been visited
                visitedUrls.add(url);
                superString += tryToReadUrl(url, pendingUrls);
            }
        }
        contentLength = contentLength = superString.split("\\s*").length;
        return superString;
    }

    /**
     * Introduced to make getSuperString shorter.
     * Attempts to connect to the given URL and returns its content + "\n".
     * Any exceptions that are thrown are ignored. Adds the content of the
     * given String to pending URLs.
     * @param url The link to attempt to read.
     * @param pendingUrls A queue on which to add the links encountered in
     * the given link.
     * @return The content of the page with address url.
     */
    private String tryToReadUrl(URL url, Queue<URL> pendingUrls) {
        String content = null;

        try {
            Page page = new Page(url);
            content = page.getContent() + "\n";
            pendingUrls.addAll(getUrlsWithinMembersDirectory(page.getUrls()));

        } catch (IOException ioe) {
            // Just ignore links that dont work
        } catch (NotAnHtmlUrlException nahue) {
        }

        return content;
    }

    /**
     * Extracts from the given URLs a subset that points to objects within this
     * member's directory.
     * @param links URLs that may or may not point to objects within this
     * member's directory
     * @return A subset of the given URLs that point to objects within this
     * member's directory
     */
    private ArrayList<URL> getUrlsWithinMembersDirectory(
            final ArrayList<URL> links) {
        // Get the path for this member's directory. It is the path up until
        // the last forward slash, /
        String base = homePageUrl.toString().replaceAll("/[^/]*$", "/");
        ArrayList<URL> result = new ArrayList<URL>();

        // Every link that starts with this member's directory points to an
        // object within that directory, so add it
        for (URL link : links) {
            if (link.toString().startsWith(base)) {
                result.add(link);
            }
        }
        return result;
    }

    /**
     * Returns the main URL of the member.
     * @return mainURL
     */
    public URL getMainURL() {
        return homePageUrl;
    }

    /**
     * Gets a map of all the words that appear in the given string and the
     * number of their occurrences.
     * @param string The string from which to extract keywords.
     * @return A hash map with keys being the words and their values being
     * their respective number of occurrences.
     */
    private HashMap<String, Integer> getWords(final String string) {
        HashMap<String, Integer> wordMap = new HashMap<String, Integer>();

        if (string.equals("")) {
            return wordMap;
        }

        // Split the content of the Page by space without punctuation marks
        // and apostrophe s. "\\W\\s", \\s by Isiah's, her...
        String str = string.toLowerCase();
        str = str.replaceAll("\\W+\\s", " ");
        str = str.replaceAll("'s", " ");
        String[] contents = str.split("\\s");

        // For every words in content, if it is in the map then update the
        // value else add it to the map.
        for (String word : contents) {
            if (wordMap.containsKey(word)) {
                wordMap.put(word, wordMap.get(word) + 1);
            } else {
                wordMap.put(word, 1);
            }
        }

        return wordMap;
    }

    /**
     * Gets the number of times the given word appears in all of this member's
     * pages.
     * @param word The word whose number of occurrences is to be returned.
     * Case insensitive.
     * Must not contain any spaces. Cannot be a sentence; must be a
     * word.
     * @return The number of times this word appears in all the faculty
     * member's pages.
     */
    public int getNumberOfOccurrences(String word) {
        word = word.toLowerCase();
        if (words.containsKey(word)) {
            return words.get(word);
        } else {
            return 0;
        }
    }

    /**
     * Gets the length of the content of all pages of this member concatenated.
     * @return The concatenated length of all content of this faculty member.
     */
    public int getContentLength() {
        return this.contentLength;
    }
}
