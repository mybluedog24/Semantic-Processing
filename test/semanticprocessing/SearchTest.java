/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package semanticprocessing;

import java.util.Iterator;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.PriorityQueue;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Frank
 */
public class SearchTest {

    private Cache cache;
    private ArrayList<String> standardList;
    private ArrayList<Integer> keywordOccurrence;

    public SearchTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {

    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws MalformedURLException {
        cache = new Cache();
        cache.add(new URL("http://www.cdf.toronto.edu/~csc207h/fall/labs/w2/w2.html"));
        cache.add(new URL("http://www.cdf.toronto.edu/~csc207h/fall/labs/w1/w1.html"));
        cache.add(new URL("http://www.cdf.toronto.edu/~csc207h/fall/labs/w3/w3.html"));
        cache.generateCache();
        standardList = new ArrayList();
        standardList.add("insert");
        standardList.add("getItem");
        standardList.add("remove");
        standardList.add("hasNext");
        standardList.add("next");
        keywordOccurrence = new ArrayList();
        keywordOccurrence.add(1);
        keywordOccurrence.add(1);
        keywordOccurrence.add(1);
        keywordOccurrence.add(1);
        keywordOccurrence.add(1);

    }

    @After
    public void tearDown() {
    }

    /**
     * Test that there is a result object for every page in cache
     * @throws MalformedURLException
     */
    @Test
    public void testGetSortedResults2() throws MalformedURLException {
        Cache cache = new Cache();
        cache.add(new URL("http://www.cdf.toronto.edu/~csc207h/fall/labs/w2/w2.html"));
        cache.generateCache();
        Search search = new Search(cache, "experience", "");
        ArrayList<Result> results = search.getResults();
        // There must be a result object for every page in cache
        assertEquals(results.size(), cache.size());
    }

}