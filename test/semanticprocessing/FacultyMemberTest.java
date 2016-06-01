/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semanticprocessing;

import java.net.MalformedURLException;
import java.net.URL;
import java.io.IOException;
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
public class FacultyMemberTest {

    FacultyMember instance;

    public FacultyMemberTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGetNumberOfOccurrences() {
        URL url;
        try {
            url = new URL("http://www.cs.toronto.edu/~pgries");
        } catch (MalformedURLException ex) {
            throw new RuntimeException("ERROR: Cannot parse given string to "
                    + "a URL. Please check the URL above.");
        }
        FacultyMember member;
        try {
            member = new FacultyMember(url);
        } catch (IOException ex) {
            throw new RuntimeException("ERROR: Cannot get content of the given"
                    + " website. Please check you're connection or try another"
                    + " link.");
        } catch (NotAnHtmlUrlException ex) {
            throw new RuntimeException("ERROR: Page reports given URL is not "
                    + "HTML. Check given URL to be sure.");
        }

        assertEquals(member.getNumberOfOccurrences("slkdfnjhg"), 0);
        System.out.println(member.getNumberOfOccurrences("Computer"));
        assertTrue(member.getNumberOfOccurrences("Computer") == 10);
    }

        @Test
    public void testGetNumberOfOccurrences2() {
        URL url;
        try {
            url = new URL("http://labs.eeb.utoronto.ca/thomson");
        } catch (MalformedURLException ex) {
            throw new RuntimeException("ERROR: Cannot parse given string to "
                    + "a URL. Please check the URL above.");
        }
        FacultyMember member;
        try {
            member = new FacultyMember(url);
        } catch (IOException ex) {
            throw new RuntimeException("ERROR: Cannot get content of the given"
                    + " website. Please check you're connection or try another"
                    + " link.");
        } catch (NotAnHtmlUrlException ex) {
            throw new RuntimeException("ERROR: Page reports given URL is not "
                    + "HTML. Check given URL to be sure.");
        }

        assertEquals(member.getNumberOfOccurrences("slkdfnjhg"), 0);
        System.out.println(member.getNumberOfOccurrences("Computer"));
        assertTrue(member.getNumberOfOccurrences("ecology") > 0);
        assertTrue(member.getNumberOfOccurrences("plant-pollinator") > 0);
    }

//    /**
//     * Test of getSuperString method, of class FacultyMember2.
//     */
//    @Test
//    public void testGetSuperString() throws IOException, NotAnHtmlUrlException {
//        System.out.print("getSuperString");
//        URL main = new URL("http://www.cdf.toronto.edu/~csc207h/fall");
//        FacultyMember member = new FacultyMember(main);
//        String result = member.getSuperString(new Page(main));
//        //Strings contained in different child-links of the website.
//
//        assertTrue(result.contains("is raised if a webpage has badly-nested "));
//        assertFalse(result.contains("input in this way assumes that you will "
//                + "get fairly well-formed HTML"));
//        assertTrue(result.contains("L5101 does NOT have a lecture this week, "
//                + "but L0101 has at least one, and possibly two."));
//    }
    /*
     * To run this test first make getUrlsWithinMembersDirectory public
    @Test
    public void testGetURLsWithinThisMembersDirectory() throws MalformedURLException {
    ArrayList<URL> links = new ArrayList<URL>();
    links.add(new URL("http://www.eecg.toronto.edu/~tsa/index.html"));
    links.add(new URL("http://www.eecg.toronto.edu/~tsa/tehe/index/"));
    links.add(new URL("http://www.eecg.toronto.edu/~tsa/room"));
    links.add(new URL("http://www.eecg.toronto.edu/index.html"));
    links.add(new URL("http://www.eecg.toronto.edu/today/index.html"));
    links.add(new URL("http://www.eecg.toronto2.edu/~tsa/"));
    ArrayList<URL> result = instance.getUrlsWithinMembersDirectory(links);
    String[] expectedResult = {
    "http://www.eecg.toronto.edu/~tsa/index.html",
    "http://www.eecg.toronto.edu/~tsa/tehe/index/",
    "http://www.eecg.toronto.edu/~tsa/room"
    };
    assertTrue(result.size() == expectedResult.length);
    for (int i = 0; i < result.size(); i++) {
    assertTrue(result.get(i).toString().equals(expectedResult[i]));
    }
    }
     *
     */
}
// http://www.eecg.toronto.edu/~tsa/
//      contains index.htm itself
//
// http://www.cs.toronto.edu/~faith/
//      contains upercase of HREF
//
// http://www.cs.toronto.edu/~azadeh/
//      contains index.html itself and inner url like personal/page4/page4.html
//
// http://www.cs.ubc.ca/~ksbooth/
//      contains #Contact (bookmark: redirect to the same page)

