/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package semanticprocessing;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Moody
 */
public class FileOpsTest {
    private FileOps fo;
    private boolean rep = false;

    public FileOpsTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("STARTING TESTS: ");
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        System.out.println("FINISHED TESTING.");
    }

    @Before
    public void setUp() {
        System.out.print("\tTest: ");
        
    }

    @After
    public void tearDown() {
        System.out.print(" - COMPLETE");
    }

    /*
     * Testing reading a null file.
     */
    @Test
    public void testNullFile() throws FileNotFoundException{
        System.out.print("read using Null File");
        File f = null;
        boolean tempVal = false;
        try {
            fo.readFile(f);
            tempVal = false;
        }  catch (NullPointerException ex){
            tempVal = true;
        }
        assertTrue("Null File expected, but not found..",tempVal);
    }

//
//    /**
//     * Test of readFile method, of class FileOps. THIS WORKS ON MY COMPUTER -
//     * TO MAKE TEST WORK - create a test.txt which contains "this is text" on
//     * your DESKTOP, and change the appropriate filepath.
//     */
//    @Test
//    public void testReadFile() throws Exception {
//        System.out.print("ReadFile");
//        File f = new File("C:\\Users\\Moody\\Desktop\\test.txt");
//        FileOps instance = new FileOps();
//        String expResult = "this is text";
//        String result = instance.readFile(f);
//        assertEquals("Retrieved text, but they were not equal.", expResult, result);
//    }
//
//    /**
//     * Test of writeToFile method, of class FileOps.
//     */
//    @Test
//    public void testWriteToFile() {
//        System.out.print("writeToFile");
//        String text = "write this into file!";
//        File f = new File("C:\\Users\\Moody\\Desktop\\testTwo.txt");
//        FileOps instance = new FileOps();
//        boolean tVal;
//        try {
//            instance.writeToFile(text, f);
//            tVal = true;
//        } catch (IOException ex) {
//            tVal = false;
//        }
//        assertTrue("IOException caught", tVal);
//    }
//
//
//    /*
//     * FileOps needs to save the file, but it does not.
//     */
//    @Test
//    public void testReadAndWriteToFile() throws FileNotFoundException, IOException{
//        System.out.print("readFile and writeFile");
//        String text = "";
//        File f = new File("C:\\Users\\Moody\\Desktop\\testThree.txt");
//
//        FileOps instance = new FileOps();
//        instance.writeToFile(text, f);
//        assertEquals(instance.readFile(f), text);
//    }
//
//
//    /**
//     * Test of readOnlineFile method, of class FileOps.
//     */
//    @Test
//    public void testReadOnlineFile() throws Exception {
//        System.out.print("readOnlineFile");
//        URL url = new URL("http://www.cdf.toronto.edu/~csc207h/fall/assignments/a2/tests/test-single.html");
//        FileOps instance = new FileOps();
//        String expResult = " A single tag: <b>Bold</b>";
//        String result = instance.readOnlineFile(url);
//        assertEquals(expResult, result);
//    }
//
//    /*
//     * Test of readOnlineFile method, with an invalid URL
//     */
//    @Test
//    public void testReadOnlineFileOnInvalidURL(){
//        System.out.print("readOnlineFile with Invalid URL");
//        boolean tempVal = false;
//        try{
//            URL url = new URL("blah");
//            fo.readOnlineFile(url);
//        } catch(MalformedURLException e){
//            tempVal = true;
//        } catch(IOException e){
//            tempVal = true;
//        }
//        assertTrue(tempVal);
//    }
//
//
    @Test
    public void testReadOnlineFile() throws IOException, NotAnHtmlUrlException {
        ArrayList result = FileOps.readOnlineFile(new URL("http://www.cs.toronto.edu/~pgries"));
        assertEquals(result.get(0).toString(), "http://www.cs.toronto.edu/~pgries/");
        assertTrue(result.get(1).toString().contains("DOCTYPE"));
    }

    @Test
        public void testReadOnlineFile2() throws MalformedURLException {
        try {
            ArrayList result = FileOps.readOnlineFile(new URL("http://appldnld.apple.com/iTunes10/061-9530.20101112.MSakc/iTunes10.1.dmg"));
            fail();
        } catch (NotAnHtmlUrlException ex) {

        } catch (IOException io) {
            fail();
        }
    }
    @Test
        public void testReadOnlineFile3() throws MalformedURLException {
        try {
            ArrayList result = FileOps.readOnlineFile(new URL("http://appldnld.apple.com/iTunes10/061sdfg-9530.20101112.MSakc/iTunes10.1.dmg"));
            fail();
        } catch (NotAnHtmlUrlException ex) {
            fail();

        } catch (IOException io) {

        }
    }
}
