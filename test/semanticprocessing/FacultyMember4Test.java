///**
// *
// * @author c9maliti
// */
//// Change getWords in FacultyMember to public then uncomment this page
//// to use this test file
//package semanticprocessing;
//
//import java.io.IOException;
//import java.net.URL;
//import java.util.Map;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
//
//
//public class FacultyMember4Test {
//
//    public FacultyMember4Test() {
//    }
//
//    @BeforeClass
//    public static void setUpClass() throws Exception {
//
//    }
//
//    @AfterClass
//    public static void tearDownClass() throws Exception {
//    }
//
//    @Before
//    public void setUp() {
//    }
//
//    @After
//    public void tearDown() {
//    }
//
//    @Test
//    public void testGetWordsEmpty() throws IOException, NotAnHtmlUrlException {
//        System.out.println("getWords");
//        String string = "";
//        FacultyMember instance = new FacultyMember(new URL("http://www.cdf.toronto.edu/~csc207h/fall/assignments/a2/tests/test-empty.html"));
//        Map result = instance.getWords(string);
//        assertTrue(result.size() == 0);
//    }
//
//    @Test
//    public void testGetWordsOneChar() throws IOException, NotAnHtmlUrlException{
//        System.out.println("getWords with just one char");
//        String string = "a";
//        FacultyMember instance = new FacultyMember(new URL("http://www.cdf.toronto.edu/~csc207h/fall/assignments/a2/tests/test-empty.html"));
//        Map result = instance.getWords(string);
//        Boolean key = result.keySet().contains("a");
//        assertTrue(key);
//        Boolean value = result.values().contains(1);
//        assertTrue(value);
//    }
//
//    @Test
//    public void testGetWordsEightRepeats() throws IOException, NotAnHtmlUrlException{
//        System.out.println("getWords with 8 repeating words");
//        String string = "Isiah Malit, Isiah Malit, Isiah Malit, Isiah Malit";
//        FacultyMember instance = new FacultyMember(new URL("http://www.cdf.toronto.edu/~csc207h/fall/assignments/a2/tests/test-empty.html"));
//        Map result = instance.getWords(string);
//        Boolean key = result.containsKey("Isiah");
//        assertTrue(key);
//        Boolean key2 = result.containsKey("Malit");
//        assertTrue(key2);
//        int value = (Integer) result.get("Isiah");
//        assertEquals(value, 4);
//        int value2 = (Integer) result.get("Malit");
//        assertEquals(value2, 4);
//    }
//
//    @Test
//    public void testGetWordsPunctuations() throws IOException, NotAnHtmlUrlException{
//        System.out.println("getWords with punctuations");
//        String string = "Isiah Malit!@#$%^ ";
//        FacultyMember instance = new FacultyMember(new URL("http://www.cdf.toronto.edu/~csc207h/fall/assignments/a2/tests/test-empty.html"));
//        Map result = instance.getWords(string);
//        Boolean key = result.containsKey("Isiah");
//        assertTrue(key);
//        Boolean key2 = result.containsKey("Malit");
//        assertTrue(key2);
//        int value = (Integer) result.get("Isiah");
//        assertEquals(value, 1);
//        int value2 = (Integer) result.get("Malit");
//        assertEquals(value2, 1);
//    }
//
//    @Test
//    public void testGetWordsEllipses() throws IOException, NotAnHtmlUrlException{
//        System.out.println("getWords with ellipses");
//        String string = "Isiah Malit... ";
//        FacultyMember instance = new FacultyMember(new URL("http://www.cdf.toronto.edu/~csc207h/fall/assignments/a2/tests/test-empty.html"));
//        Map result = instance.getWords(string);
//        Boolean key = result.containsKey("Isiah");
//        assertTrue(key);
//        Boolean key2 = result.containsKey("Malit");
//        assertTrue(key2);
//        int value = (Integer) result.get("Isiah");
//        assertEquals(value, 1);
//        int value2 = (Integer) result.get("Malit");
//        assertEquals(value2, 1);
//    }
//
//     @Test
//    public void testGetWordsShortPar() throws IOException, NotAnHtmlUrlException{
//        System.out.println("getWords short paragraph");
//        String string = "Hi, I am 20 years old. I am taking CSC207. ";
//        FacultyMember instance = new FacultyMember(new URL("http://www.cdf.toronto.edu/~csc207h/fall/assignments/a2/tests/test-empty.html"));
//        Map result = instance.getWords(string);
//        System.out.println(result);
//        Boolean key = result.containsKey("Hi");
//        assertTrue(key);
//        Boolean key2 = result.containsKey("I");
//        assertTrue(key2);
//        Boolean key3 = result.containsKey("am");
//        assertTrue(key3);
//        Boolean key4 = result.containsKey("20");
//        assertTrue(key4);
//        Boolean key5 = result.containsKey("years");
//        assertTrue(key5);
//        Boolean key6 = result.containsKey("old");
//        assertTrue(key6);
//        Boolean key7 = result.containsKey("taking");
//        assertTrue(key7);
//        Boolean key8 = result.containsKey("CSC207");
//        assertTrue(key8);
//        int value = (Integer) result.get("Hi");
//        assertEquals(value, 1);
//        int value2 = (Integer) result.get("I");
//        assertEquals(value2, 2);
//        int value3 = (Integer) result.get("am");
//        assertEquals(value3, 2);
//        int value4 = (Integer) result.get("20");
//        assertEquals(value4, 1);
//        int value5 = (Integer) result.get("years");
//        assertEquals(value5, 1);
//        int value6 = (Integer) result.get("old");
//        assertEquals(value6, 1);
//        int value7 = (Integer) result.get("taking");
//        assertEquals(value7, 1);
//        int value8 = (Integer) result.get("CSC207");
//        assertEquals(value8, 1);
//
//    }
//
//     @Test
//    public void testGetWordsCaseSensitivity() throws IOException, NotAnHtmlUrlException{
//        System.out.println("getWords with different cases");
//        String string = "Isiah isiah iSiAH isiaH ";
//        FacultyMember instance = new FacultyMember(new URL("http://www.cdf.toronto.edu/~csc207h/fall/assignments/a2/tests/test-empty.html"));
//        Map result = instance.getWords(string);
//        Boolean key = result.containsKey("Isiah");
//        assertTrue(key);
//        Boolean key2 = result.containsKey("isiah");
//        assertTrue(key2);
//        Boolean key3 = result.containsKey("iSiAH");
//        assertTrue(key3);
//        Boolean key4 = result.containsKey("isiaH");
//        assertTrue(key4);
//        int value = (Integer) result.get("Isiah");
//        assertEquals(value, 1);
//        int value2 = (Integer) result.get("isiah");
//        assertEquals(value2, 1);
//        int value3 = (Integer) result.get("iSiAH");
//        assertEquals(value3, 1);
//        int value4 = (Integer) result.get("isiaH");
//        assertEquals(value4, 1);
//    }
//}
