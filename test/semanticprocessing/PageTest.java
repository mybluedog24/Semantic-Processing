package semanticprocessing;

import java.net.URL;
import java.io.IOException;
import java.net.MalformedURLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * PageTest class - Creates a Page instance, and tests it ability to
 * retrieve URLs, and content
 * @author Moody
 */
public class PageTest {
    private Page page;
    private String contentNoHTML;
    private URL url;

    public PageTest() {
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
    public void setUp() throws MalformedURLException, IOException, NotAnHtmlUrlException {
        System.out.print("\tTest: ");
            page = new Page(new URL("http://www.cs.toronto.edu/~faith/"));
            contentNoHTML = page.getContent();
            url = page.getURL();
    }

    @After
    public void tearDown() {
        System.out.print(" - COMPLETE");
    }

    @Test
    public void testEmptiness() {
        System.out.print("testEmptiness");
        if(url == null)
            fail("URL is empty");
        else if(contentNoHTML == null)
            fail("No content");
        else{
            assertTrue(true);
        }
    }

    /**
     * Test of getContent method, of class Page.
     */
    @Test
    public void testGetContent() throws MalformedURLException, IOException, NotAnHtmlUrlException {
            System.out.print("getContent");
            Page instance = new Page(new URL("http://www.cs.toronto.edu/~faith/"));
            String expResult = contentNoHTML;
            String result = instance.getContent();
            assertEquals(expResult, result);
    }

    /**
     * Test of getURL method, of class Page.
     */
    @Test
    public void testGetURL() throws MalformedURLException, IOException, NotAnHtmlUrlException{
            System.out.print("getURL");
            Page instance = new Page(new URL("http://www.cs.toronto.edu/~faith/"));
            URL expResult = url;
            URL result = instance.getURL();
            assertEquals(expResult, result);

    }

    @Test
    public void testRemoveHTML() throws MalformedURLException, IOException, NotAnHtmlUrlException{
        System.out.print("removeHTML");
        Page instance = new Page(new URL("http://www.cs.toronto.edu/~faith/"));
        String result = instance.getContent();
        if(result.contains("<!--") || result.contains("<") ||
                result.contains(">") || result.contains("<br>") ||
                result.contains("<!DOCTYPE") || result.contains("<a") ||
                result.contains("<img"))
            fail("String still contains HTML, even though it's been passed"
                    + " through removeHTML");
        else
            assertTrue(true);
    }

    @Test
    public void testBeforeAndAfterLength() throws IOException, NotAnHtmlUrlException{
        System.out.print("BeforeAndAfterLength");
        Page instance = new Page(new URL("http://www.cs.toronto.edu/~faith/"));
        String afterResult = instance.getContent();
        
        String beforeResult = FileOps.readOnlineFile(new URL("http://www.cs.toronto.edu/~faith/")).get(1).toString();

        assertTrue("String before and after lengths are not intelligible.", beforeResult.length() > afterResult.length() );
    }

    // Invalid test. Alot has changed since this test was written. Too lazy
    // fix that scary paragpraph. - Hussam
//    @Test
//    public void testAllTextIncluded() throws MalformedURLException, IOException, NotAnHtmlUrlException{
//        System.out.print("allTextIncluded");
//        Page instance = new Page(new URL("http://www.cs.toronto.edu/~faith/"));
//        String result = instance.getContent();
//        String everythingFromWebsite = "Faith Ellen Professor Faith Ellen "
//                + "Department of Computer Science "
//                + "University of Toronto 10 King's College Road Toronto Ontario "
//                + "CANADA M5S 3G4 Office  Sandford Fleming 2302C Email  faith at"
//                + " cs dot toronto dot edu Phone  416 978 6183 Fax 416 946 8498 "
//                + "My research is in the theory of distributed computing I "
//                + "particularly like proving lower bounds on the complexity "
//                + " of concrete problems with the goal of understanding how "
//                + "parameters of various models of computation affect their "
//                + "computational power I also study data structures in distri"
//                + "buted and sequential models 2221 Course Information Journal"
//                + " Publications Conference Publications Slides from Talks "
//                + "Other Publications Unpublished Manuscripts";
//         String[] theList = result.split(" +");
//         String[] theList2 = everythingFromWebsite.split(" +");
//
//         for (String x:theList) {
//             boolean t = true;
//             for (int i=0; i < theList2.length; i++){
//                 if(x.equals(theList2[i])){
//                     theList2[i] = "@";
//                     t = false;
//                     break;
//                 }
//             }
//             if (t) {
//                 fail("FAILED HERE");
//             }
//         }
//         for (String y: theList2){
//             if (y == null ? "@" != null : !y.equals("@")){
//                fail("NO I FAILED OVER HERE");
//             }
//         }
//    }

    @Test
    public void testURLValidity()
    {
        System.out.print("URLValidity");
        try{
            URL url = new URL("http://www.cs.toronto.edu/~faith/");
        }catch(MalformedURLException ex){
            fail("Malformed URL Exception: " + ex);
        }
    }

    @Test
    public void testInvalidURL() throws NotAnHtmlUrlException{
        System.out.print("InvalidURL");
        boolean temp = false;
        try{
            Page instance = new Page(new URL("lol"));
            temp = false;
        } catch(IOException e) {
            temp = true;
        }
        assertTrue(temp);
    }

}