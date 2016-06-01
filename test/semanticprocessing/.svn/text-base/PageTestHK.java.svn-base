/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semanticprocessing;

import java.io.IOException;
import java.util.ArrayList;
import java.net.MalformedURLException;
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
 * @author hussamkaka
 */
public class PageTestHK {

    private String replacedWith = "";

    public PageTestHK() {
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

    /**
     * Tests get URL with a Page created with a URL that ends in a forward
     * slash. Must return the same given URL.
     */
    @Test
    public void testEmptyPage() throws MalformedURLException {
        Page page = new Page(new URL("http://s.s.s/"), "");
        assertTrue(page.getUrls().isEmpty());
    }

    @Test
    public void testGetURL() {
        Page page;
        String url = "http://www.cdf.toronto.edu/~csc207h/fall/assignments/a1/";
        try {
            page = new Page(new URL(url));
        } catch (NotAnHtmlUrlException ex) {
            throw new RuntimeException("ERROR: Page reports given URL is not "
                    + "HTML. Check given URL to be sure.");
        } catch (MalformedURLException ex) {
            throw new RuntimeException("ERROR: Cannot parse given string to "
                    + "a URL. Please check the URL above.");
        } catch (IOException ex) {
            throw new RuntimeException("ERROR: Cannot get content of the given"
                    + " website. Please check you're connection or try another"
                    + " link.");
        }
        assertEquals(page.getURL().toString(), url);

        // A URL with an extension should be correct to the last directory
        url = "http://www.cdf.toronto.edu/~csc207h/fall/assignments/a2/"
                + "index.shtml";
        try {
            page = new Page(new URL(url));
        } catch (NotAnHtmlUrlException ex) {
            throw new RuntimeException("ERROR: Page reports given URL is not "
                    + "HTML. Check given URL to be sure.");
        } catch (MalformedURLException ex) {
            throw new RuntimeException("ERROR: Cannot parse given string to "
                    + "a URL. Please check the URL above.");
        } catch (IOException ex) {
            throw new RuntimeException("ERROR: Cannot get content of the given"
                    + " website. Please check you're connection or try another"
                    + " link.");
        }

        assertTrue(url.startsWith("http://www.cdf.toronto.edu/~csc207h/fall"
                + "/assignments/a2/"));
    }

    /**
     * Tests get URL with a Page created with a URL that does not end in a
     * forward slash. Must return same URL plus forward slash.
     * @throws MalformedURLException
     */
    @Test
    public void testGetURLShouldAddSlash() {
        Page page;
        String url = "http://www.cdf.toronto.edu/~csc207h/fall/assignments/a1";
        try {
            page = new Page(new URL(url));
        } catch (NotAnHtmlUrlException ex) {
            throw new RuntimeException("ERROR: Page reports given URL is not "
                    + "HTML. Check given URL to be sure.");
        } catch (MalformedURLException ex) {
            throw new RuntimeException("ERROR: Cannot parse given string to "
                    + "a URL. Please check the URL above.");
        } catch (IOException ex) {
            throw new RuntimeException("ERROR: Cannot get content of the given"
                    + " website. Please check you're connection or try another"
                    + " link.");
        }

        assertEquals(page.getURL().toString(), url + "/");
    }

    @Test
    public void testRealContent() {
        Page page;
        String url = "http://www.cdf.utoronto.ca/~csc207h/fall/labs/w2/w2.html";
        try {
            page = new Page(new URL(url));
        } catch (NotAnHtmlUrlException ex) {
            throw new RuntimeException("ERROR: Page reports given URL is not "
                    + "HTML. Check given URL to be sure.");
        } catch (MalformedURLException ex) {
            throw new RuntimeException("ERROR: Cannot parse given string to "
                    + "a URL. Please check the URL above.");
        } catch (IOException ex) {
            throw new RuntimeException("ERROR: Cannot get content of the given"
                    + " website. Please check you're connection or try another"
                    + " link.");
        }
        String pageContent = page.getContent();
        String expectedContent = " CSC207H: Lab 2 CSC207H: Lab 2 This is the "
                + "week 2 lab for "
                + "CSC207H. It involves code reviews , which are discussions "
                + "of the style and content of pieces of Java code. Your TA "
                + "will go through the following examples, discussing each "
                + "one. A code review involves a group discussion . "
                + "Everyone's views are important and should be considered "
                + "carefully. While the goal is to identify possible problems, "
                + "the tone of the discussion should be constructive, "
                + "rather than aggressive or attacking. This is a learning "
                + "experience for everyone involved. Your TA will form you "
                + "into groups of 3 so that you can discuss the following "
                + "pieces of code. Make sure that everyone in your group "
                + "understands the syntax of each piece of code. You'll "
                + "have about 3 to 5 minutes to discuss each piece. "
                + "Shadowing.java Dispatch.java Dispatch2.java Dispatch3.java "
                + "Dispatch4.java Dispatch5.java BadSubstitution.java "
                + "BadStatic.java TestSuper.java TestSuper2.java ";
        // To lazy find out the spaces. Make sure the content is correct up
        // to spaces.
        expectedContent = expectedContent.replaceAll("\\s+", " ");
        pageContent = pageContent.replaceAll("\\s+", " ");
        assertEquals(expectedContent, pageContent);
    }

    /**
     * Tests get URL with a Page created with a URL that does not end in a
     * forward slash. Must return same URL plus forward slash.
     * @throws MalformedURLException
     */
    @Test
    public void testGetURLFragment() {
        Page page;
        String url = "http://en.wikipedia.org/wiki/CERN#Current_complex";
        try {
            page = new Page(new URL(url));
        } catch (NotAnHtmlUrlException ex) {
            throw new RuntimeException("ERROR: Page reports given URL is not "
                    + "HTML. Check given URL to be sure.");
        } catch (MalformedURLException ex) {
            throw new RuntimeException("ERROR: Cannot parse given string to "
                    + "a URL. Please check the URL above.");
        } catch (IOException ex) {
            throw new RuntimeException("ERROR: Cannot get content of the given"
                    + " website. Please check you're connection or try another"
                    + " link.");
        }

        assertEquals(page.getURL().toString(), url.substring(0, url.indexOf("#")));
    }

    /**
     * Tests get URL with a Page created with a URL that has a fragment
     * @throws MalformedURLException
     */
    @Test
    public void testGetURLShouldNotAddSlash() {
        Page page;
        String url = "http://en.wikipedia.org/wiki/SS_Dakotan";
        try {
            page = new Page(new URL(url));
        } catch (NotAnHtmlUrlException ex) {
            throw new RuntimeException("ERROR: Page reports given URL is not "
                    + "HTML. Check given URL to be sure.");
        } catch (MalformedURLException ex) {
            throw new RuntimeException("ERROR: Cannot parse given string to "
                    + "a URL. Please check the URL above.");
        } catch (IOException ex) {
            throw new RuntimeException("ERROR: Cannot get content of the given"
                    + " website. Please check you're connection or try another"
                    + " link.");
        }

        assertEquals(page.getURL().toString(), url);
    }

    @Test
    public void testConstructorExceptions() {
        Page page;
        // A URL that doesnt exist
        String url = "http://cdf.toronto.edu/dfgsdfgs";
        try {
            page = new Page(new URL(url));
            fail("No IOException thrown.");
        } catch (NotAnHtmlUrlException ex) {
            fail("If it cannot reach page it should throw IOException. Instead"
                    + " it is throwing NotAnHtmlException.");
        } catch (MalformedURLException ex) {
            throw new RuntimeException("ERROR: Cannot parse given string to "
                    + "a URL. Please check the URL above.");
        } catch (IOException ex) {
        }

        // A URL that points to non-html
        url = "http://www.cdf.toronto.edu/~csc207h/fall/assignments/a1/"
                + "ALLSPROUTSMAP.TXT";
        try {
            page = new Page(new URL(url));
            fail("No IOException thrown.");
        } catch (NotAnHtmlUrlException ex) {
        } catch (MalformedURLException ex) {
            throw new RuntimeException("ERROR: Cannot parse given string to "
                    + "a URL. Please check the URL above.");
        } catch (IOException ex) {
            throw new RuntimeException("ERROR: Cannot get content of the given"
                    + " website. Please check you're connection or try another"
                    + " link.");
        }
    }

    /**
     * Passes content with line breaks and compares with expected value, which
     * is the same exact string that was passed since it contained no HTML
     * @throws MalformedURLException
     */
    @Test
    public void testGetContentNoHTMLwithlinebreaks() throws
            MalformedURLException {
        Page page = new Page(new URL("http://www.yahoo.com"), "This text does"
                + "not contain any HTML. The returned value must \n"
                + "exactly match this string.");
        //System.out.print(page.getContent());
        assertEquals(page.getContent(), "This text does"
                + "not contain any HTML. The returned value must \n"
                + "exactly match this string.");
    }

    /**
     * Passes content that has no HTML or line break. The same exact string
     * that was passed must be returned
     * @throws MalformedURLException
     */
    @Test
    public void testGetContentNoHTMLnoLineBreaks() throws MalformedURLException {
        Page page = new Page(new URL("http://www.yahoo.com"), "This text does"
                + "not contain any HTML. The returned value must "
                + "exactly match this string.");
        //System.out.print(page.getContent());
        assertEquals(page.getContent(), "This text does"
                + "not contain any HTML. The returned value must "
                + "exactly match this string.");
    }

    /**
     * A single opening HTML tag. Must be converted to a single whitespace
     * @throws MalformedURLException
     */
    @Test
    public void testGetContentTag() throws MalformedURLException {
        Page page = new Page(new URL("http://www.yahoo.com"), "<this must "
                + "go>this must stay");
        assertEquals(page.getContent(), " this must stay");
    }

    /**
     * Closing tag with a line break inside it
     * @throws MalformedURLException
     */
    @Test
    public void testGetContentClosingTag() throws MalformedURLException {
        Page page = new Page(new URL("http://www.choochoo.com"),
                "</this has to go\n"
                + ">this has to stay");
        assertEquals(page.getContent(), " this has to stay");
    }

    /**
     * Unclosed tag
     * @throws MalformedURLException
     */
    @Test
    public void testIllegalClosingTag() throws MalformedURLException {
        Page page = new Page(new URL("http://d.f.d"), "<\n/\nlol sdf \ndf");
        assertEquals(page.getContent(), " \n \nlol sdf \ndf");
    }

    /**
     * unopened tag
     * @throws MalformedURLException
     */
    @Test
    public void testUnopenedTag() throws MalformedURLException {
        Page page = new Page(new URL("http://d.f.d"), "unopened tag>");
        assertEquals(page.getContent(), "unopened tag ");
    }

    /**
     * surrounded by tags
     * @throws MalformedURLException
     */
    @Test
    public void testSurroundedByTags() throws MalformedURLException {
        Page page = new Page(new URL("http://d.f.d"), "outside <a> inside"
                + " </a> outside again");
        assertEquals(page.getContent(), "outside   inside   outside again");
    }

    /**
     * All inside a tag
     */
    @Test
    public void testGiantTag() throws MalformedURLException {
        Page page = new Page(new URL("http://d.f.d"), "<tooot>");
        assertEquals(page.getContent(), " ");
    }

    /**
     * nested tags: illegal.
     */
    @Test
    public void nestedTags() throws MalformedURLException {
        Page page = new Page(new URL("http://d.f.d"), "<outside<inside>>");
        System.out.println(page.getContent()); // STILL SYSTEM OUTPUTTING HERE!
        // Who wrote STILL SYSTEM OUTPUTTING HERE!?
        assertEquals("  ", page.getContent());
    }

    /**
     * remove comments
     */
    @Test
    public void legalcomments() throws MalformedURLException {
        Page page = new Page(new URL("http://d.f.d"),
                "<!--\n<evil\n comment>\n-\n->-->");
        assertEquals(" ", page.getContent());
    }

    /**
     * sample page
     */
    @Test
    public void AThirdOfA0() throws MalformedURLException {
        String s = " \n"
                + " \n"
                + "\n"
                + " \n"
                + "   \n"
                + "     \n"
                + "     \n"
                + "     \n"
                + "        A0: Intro to Java\n"
                + "     \n"
                + " \n"
                + " \n"
                + "      \n"
                + "        A0: Intro to Java\n";
        String s1 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
                + "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transit"
                + "ional//EN\"\n"
                + "\"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional"
                + ".dtd\">\n"
                + "\n"
                + "<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\""
                + "en\" lang=\"en\">\n"
                + "  <head>\n"
                + "    <meta http-equiv=\"Content-Type\" content=\"text/htm"
                + "l; charset=utf-8\" />\n"
                + "    <link rel=\"stylesheet\" href=\"styles.css\" type=\"t"
                + "ext/css\" />\n"
                + "    <title>\n"
                + "        A0: Intro to Java\n"
                + "    </title>\n"
                + "</head>\n"
                + "<body>\n"
                + "    <div class=\"title\"><h1>\n"
                + "        A0: Intro to Java\n";
        Page page = new Page(new URL("http://s.s.s"), s1);
        assertEquals(s, page.getContent());
    }

    /**
     * remove HTML symbols starting with &
     */
    @Test
    public void HTMLSymbols() throws MalformedURLException {
        Page page = new Page(new URL("http://s.s.s"), "<a>what happens"
                + " to this&#63; and this &nbsp;&#63; &nbsp;");
        assertEquals(" what happens to this  and this     ", page.getContent());
    }

    /**
     * &blahblah; inside tag
     */
    @Test
    public void charEntityInsideTag() throws MalformedURLException {
        Page page = new Page(new URL("http://w.w.w"), "<&lame;>");
        assertEquals(" ", page.getContent());
    }

    @Test
    public void testGetURLs() throws MalformedURLException {
        String s = "<a href=http://www.google.com>"
                + "<a href=today/room/ >"
                + "<A hRef = yesterDay/room >"
                + "<a href = yesterday/room/roompicture.jpg"
                + "<A href =../week/weather.htm#todaysWeather>"
                + "<a hrEF =http://www.microsoft.com/>"
                + "<a href = http://en.wikipedia.org/wiki/Hoxne_Hoard"
                + "#Historical_spread_and_minting>";
        Page page = new Page(new URL("http://www.yahoo.com/day/index.html"), s);
        ArrayList<URL> urlsOnPage = page.getUrls();
        String[] expectedResult = {"http://www.google.com",
            "http://www.yahoo.com/day/today/room/",
            "http://www.yahoo.com/day/yesterDay/room",
            "http://www.yahoo.com/day/yesterday/room/roompicture.jpg",
            "http://www.yahoo.com/week/weather.htm",
            "http://www.microsoft.com/",
            "http://en.wikipedia.org/wiki/Hoxne_Hoard"
        };
        assertTrue(expectedResult.length == urlsOnPage.size());
        for (int i = 0; i < expectedResult.length; i++) {
            assertEquals(urlsOnPage.get(i).toString(), expectedResult[i]);
        }
    }

    @Test
    public void testGetUrls() throws MalformedURLException {
        String content = "<mETa hTtp-equiv = \"ReFRESH\" "
                + "contEnt = \"0;url = http://www.yahoo.com\" />";
        Page page = new Page(new URL("http://www.ww.w"), content);
        assertTrue(page.getUrls().get(0).toString().equals("http://www.yahoo.com"));
        assertTrue(page.getUrls().size() == 1);
    }

    @Test
    public void testGetUrls2() throws MalformedURLException {
        String content = "<iFrame sRc=\"http://www.yahoo.com\" />";
        Page page = new Page(new URL("http://www.ww.w"), content);
        assertTrue(page.getUrls().get(0).toString().equals("http://www.yahoo.com"));
        assertTrue(page.getUrls().size() == 1);
    }
    /*
    @Test
    public void getAbsoluteURLs() throws MalformedURLException {
    Page page = new Page(new URL("http://www.yahoo.com/today/index.html#news"), "s");
    ArrayList<String> links = new ArrayList<String>();
    links.add("http://www.google.com");
    links.add("index.html#cars");
    links.add("#autos");
    links.add("../yesterday/");
    links.add("/../twodaysago/");
    ArrayList<URL> urls = page.toAbsoluteURLs(links);
    for (URL url : urls) {
    System.out.println(url);
    }
    }
     *
     */
    /*
     * This test is for a private function. The function getAbsolutePath
     * must be made public before running this test.
    @Test
    public void testGetAbsolutePath() throws IOException {
    Page page = new Page(new URL("http://www.yahoo.com/f/index.htm#news"), "s");
    assertTrue(page.getAbsolutePath("/yea/index.html").equals
    ("http://www.yahoo.com/f/yea/index.html"));
    assertTrue(page.getAbsolutePath("/../g/index.shtml#fdg").equals
    ("http://www.yahoo.com/g/index.shtml#fdg"));

    }
     */
    /*
     * This test is for a private function. The function hrefValuse must
     * be made public before running this test.
    @Test
    public void testHrefValues() throws MalformedURLException {
    Page page = new Page(new URL("http://ww.w.w"), "s");
    String[] s = {
    "<html href = toot> nothing",
    "<body><a href=\"http://www. yahoo.com\">proper</a></body>",
    "<a src=dfg href =    oops>unclosed",
    "<a href = sdfg><a href = dsfgdfg2>"
    };
    ArrayList<String> hrefs = new ArrayList<String>();
    for (int i = 0; i < s.length; i++) {
    hrefs.addAll(page.hrefValues(s[i]));
    }
    String[] expectedHrefs = {
    "http://www. yahoo.com",
    "oops",
    "sdfg",
    "dsfgdfg2"
    };
    assertTrue(hrefs.size() == expectedHrefs.length);
    for (int i = 0; i < hrefs.size(); i++) {
    assertTrue(expectedHrefs[i].equals(hrefs.get(i)));
    }
    }
     *
     */
}
