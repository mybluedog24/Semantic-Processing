/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package semanticprocessing;

import java.util.ArrayList;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hussamkaka
 */
public class CacheTestHK {
    private Cache cache;
    private URL url1;
    private URL url2;
    private URL url3;
    private URL invalidURL;

    public CacheTestHK() {
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
        url1 = new URL("http://www.cdf.toronto.edu/~csc207h/fall/labs/w2/w2.html");
        url2 = new URL("http://www.cdf.toronto.edu/~csc207h/fall/labs/w1/w1.htm"
                + "l");
        url3 = new URL("http://www.cdf.toronto.edu/~csc207h/fall/labs/w3/w3.htm"
                + "l");
        invalidURL = new URL("http://www.cdf.toronto.edu/~csc207h/fall/labs/w2/"
                 + "w232.html");
    }

    @After
    public void tearDown() {
        cache = null;
        url1 = null;
    }

    /**
     * Checks if get(i) raises index out of bounds exception.
     * @param i The index to call get on
     * @return True if IOOBE is raised, false otherwise
     */
    private boolean getRaisesIOOBException(int i) {
        boolean exceptionRaised = false;
        try {
            FacultyMember member = cache.get(i);
        } catch (IndexOutOfBoundsException ex) {
            exceptionRaised = true;
        }
        return exceptionRaised;
    }
    /**
     * Test emptiness: isEmpty, URLQueueIsEmpty, get must throw exception
     */
    @Test
    public void testEmpty() {
        assertTrue(cache.isEmpty());
        assertTrue(cache.pendingURLsIsEmpty());
        assertTrue(getRaisesIOOBException(0));
    }

    /**
     * Test addURL
     */
    @Test
    public void testAddURL() {
        assertTrue(cache.add(url1));
        assertTrue(cache.isEmpty());
        assertTrue(getRaisesIOOBException(0));
        ArrayList<URL> urlQ = cache.getPendingURLs();
        assertTrue(urlQ.size() == 1);
        assertTrue(urlQ.contains(url1));
        // Ensure no duplication
        assertTrue(!cache.add(url1));
        assertTrue(cache.isEmpty());
        assertTrue(getRaisesIOOBException(0));
        urlQ = cache.getPendingURLs();
        assertTrue(urlQ.size() == 1);
        assertTrue(urlQ.contains(url1));

        cache.generateCache();
        assertTrue(!cache.add(url1));
        assertTrue(cache.getPendingURLs().isEmpty());
    }

    /**
     * Test generate cache empty
     */
     @Test
     public void testGenerateCacheEmpty() {
         cache.generateCache();
         assertTrue(cache.isEmpty());
     }

     /**
      * Test generate cache
      * @throws MalformedURLException: if thrown means test case has a bug
      */
     @Test
     public void testGenerateCache() throws MalformedURLException {
         assertTrue(cache.add(url1));
         ArrayList<URL> errors = cache.generateCache();
         assertTrue(cache.size() == 1);
         assertTrue(!cache.isEmpty());
         assertTrue(cache.getPendingURLs().isEmpty());
         assertTrue(errors.isEmpty());
         assertTrue(getRaisesIOOBException(-1));
         assertTrue(getRaisesIOOBException(1));
         assertTrue(!getRaisesIOOBException(0));

         assertTrue(!cache.add(url1));

         cache.generateCache();
         assertTrue(cache.size() == 1);

         // Valid URL format, but member does not exist
         assertTrue(cache.add(invalidURL));
         assertTrue(cache.getPendingURLs().size() == 1);
         errors = cache.generateCache();
         assertTrue(cache.size() == 1);
         assertTrue(cache.getPendingURLs().isEmpty());
         assertTrue(errors.size() == 1);
         assertTrue(errors.contains(invalidURL));
         assertTrue(cache.get(0).getMainURL().equals(url1));
     }

     /**
      * Test remove
      * @throws MalformedURLException
      */
     @Test
     public void testRemoveURLandGet() throws MalformedURLException {
         assertTrue(!cache.remove(url1));
         cache.add(url1);
         boolean value = cache.remove(url1);
         assertTrue(value);
         assertTrue(cache.isEmpty());
         assertTrue(cache.pendingURLsIsEmpty());

         cache.add(url1);
         cache.generateCache();
         assertTrue(cache.remove(url1));
         assertTrue(cache.isEmpty());
         assertTrue(cache.pendingURLsIsEmpty());

         assertTrue(cache.add(url1));

         cache.add(url2);
         cache.add(url3);
         cache.generateCache();

         assertTrue(cache.remove(url1));
         assertTrue(cache.remove(url2));
         cache.add(url1);
         assertTrue(cache.remove(url1));
         assertFalse(cache.remove(url2));
         assertFalse(cache.remove(url1));


         assertTrue(cache.size() == 1);
         assertTrue(cache.get(0).getMainURL().equals(url3));
     }

     /**
      * Test get and iterator
      */
     public void testGetandIter() throws MalformedURLException {
         cache.add(url1);
         cache.add(url2);
         cache.add(url3);
         assertTrue(getRaisesIOOBException(0));
         assertTrue(getRaisesIOOBException(-1));

         cache.generateCache();
         assertFalse(getRaisesIOOBException(0));
         assertFalse(getRaisesIOOBException(1));
         assertFalse(getRaisesIOOBException(2));
         assertTrue(getRaisesIOOBException(3));
         assertTrue(getRaisesIOOBException(-1));
         assertTrue(cache.size() == 3);

         ArrayList<FacultyMember> members = new ArrayList<FacultyMember>();
         for (FacultyMember member : cache) {
             members.add(member);
             assertTrue(member.getMainURL() == url1 || member.getMainURL() == url2 ||
                     member.getMainURL() == url3);
         }
         assertTrue(members.get(0) == cache.get(0));
         assertTrue(members.get(1) == cache.get(1));
         assertTrue(members.get(2) == cache.get(2));

         assertTrue(members.size() == 3);
     }

     @Test
     public void testIterator() {
         Cache cache = new Cache();
         cache.add(url1);
         cache.generateCache();
         boolean success = false;
         for (FacultyMember fm : cache) {
             success = true;
         }
         assertTrue(success);
     }
}