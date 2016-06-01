/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semanticprocessing;

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
 * @author Isiah
 */
public class ResultTest {
    private FacultyMember facMember;
    public ResultTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws IOException, NotAnHtmlUrlException {
        facMember = new FacultyMember(new
                URL("http://www.cdf.toronto.edu/~csc207h/"
                + "fall/labs/w2/w2.html"));       
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getPage method, of class Result.
     */
    @Test
    public void testGetPage() {
        System.out.println("getPage");
        Result instance = new Result(facMember, 0);
        FacultyMember expResult = facMember;
        FacultyMember result = instance.getPage();
        assertEquals(expResult, result);
    }

    /**
     * Test of getScore method, of class Result.
     */
    @Test
    public void testGetScore() {
        System.out.println("getScore");
        Result instance = new Result(facMember, 9);
        double result = instance.getScore();
        assertTrue(result == 9);
    }

    /**
     * Test of compareTo method, of class Result.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Result other = new Result(facMember, 3);
        Result instance = new Result(facMember, 5);
        assertTrue(instance.compareTo(other) > 0);
    }

}