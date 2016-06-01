///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//
//package semanticprocessing;
//
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//import java.util.ArrayList;
//
///**
// *
// * @author verarizvi
// */
//public class TestSearch_3Func {
//    private Search search;
//    private Cache cache;
//    private ArrayList<String> wordList;
//    private ArrayList<Integer> occurrence;
//    private String ignorant;
//    private String prob;
//
//
//
//    public TestSearch_3Func() {
//    }
//
//    @BeforeClass
//    public static void setUpClass() throws Exception {
//    }
//
//    @AfterClass
//    public static void tearDownClass() throws Exception {
//    }
//
//    @Before
//    public void setUp() {
//        wordList = new ArrayList();
//        occurrence = new ArrayList();
//        search = new Search(cache, wordList, occurrence);
//        ignorant = '\n' +  "   i  /./'   234   bfb " +'\n' + "      hi      we   you "
//                + "they  ";
//        prob = '\n' + "     I    546 girl  girl's  girls  girls'  play "
//                + "tog'ether     we  you   hello /.../!&   & *    9" + '\n';
//    }
//
//    @After
//    public void tearDown() {
//    }
//
//    // TODO add test methods here.
//    // The methods must be annotated with annotation @Test. For example:
//    //
//    // @Test
//    // public void hello() {
//
//    @Test
//    // testing extractkeywordsfrom problem
//    public void testExtractKeywordsfromProblem(){
//        ArrayList[]  result = search.extractKeywordsFromProblem(ignorant, prob);
//        ArrayList l = new ArrayList();
//        l.add("546");
//        l.add("girl");
//        l.add("girls");
//        l.add("play");
//        l.add("together");
//        l.add("hello");
//        l.add("9");
//
//        ArrayList m = new ArrayList();
//        m.add(1);
//        m.add(2);
//        m.add(2);
//        m.add(1);
//        m.add(1);
//        m.add(1);
//        m.add(1);
//
//        assertEquals(result[0], l);
//        assertEquals(result[1], m);
//    }
//
//    @Test
//    public void testEKFP() {
//        System.out.println("\n\ntestEKFP");
//        String words = "I am an amazing chemistry researcher. I have done "
//                + "numerous research problems in nanochemistry, the most recent"
//                + "being \"Investigating the Light Absorbtion Properties of"
//                + " Alkanes\". Chemistry of alkanes was thought to be dull,"
//                + " but is now considered to be one of the most amazing "
//                + "products in chemistry.";
//        String ignoredWords = "I am an amazing have being in the most but is now"
//                + " now be one of product.";
//        ArrayList[] result = search.extractKeywordsFromProblem(ignoredWords, words);
//        assertTrue(result[0].contains("chemistry"));
//        int indexChemistry = result[0].indexOf("chemistry");
//        System.out.println("chemistry occurrence: " + result[1].get(indexChemistry));
//        assertTrue((Integer)result[1].get(indexChemistry) == 3);
//
//    }
//
//    @Test
//    public void testEKFP2() {
//        System.out.println("\n\ntestEKFP2");
//        String words = "My friend has an amazing car: a Lamborghini. My "
//                + "friend's car is awesome.";
//        String ignoredWords = "I am an amazing have being in the most but is now"
//                + " now be one of product.";
//        ArrayList[] result = search.extractKeywordsFromProblem(ignoredWords, words);
//        assertTrue(result[0].contains("friend"));
//        int indexFriend = result[0].indexOf("friend");
//        System.out.println("friend occurrence: " + result[1].get(indexFriend));
//        assertTrue((Integer)result[1].get(indexFriend) == 2);
//    }
//
//        @Test
//    public void testEKFP3() {
//            System.out.println("\n\ntestEKFP3");
//        String words = "roommate";
//        String ignoredWords = "room mate";
//        ArrayList[] result = search.extractKeywordsFromProblem(ignoredWords, words);
//        assertTrue(result[0].contains("roommate"));
//        int indexRoommate = result[0].indexOf("roommate");
//        System.out.println("roommate occurrence: " + result[1].get(indexRoommate));
//        assertTrue((Integer)result[1].get(indexRoommate) == 1);
//
//    }
//
//            @Test
//    public void testEKFP4() {
//        System.out.println("\n\ntestEKFP4");
//        String words = "lame things  annoy; me";
//        String ignoredWords = "me";
//        ArrayList[] result = search.extractKeywordsFromProblem(ignoredWords, words);
//        assertTrue(result[0].contains("annoy"));
//        int indexChemistry = result[0].indexOf("annoy");
//        System.out.println(result[0]);
//        System.out.println("annoy occurrence: " + result[1].get(indexChemistry));
//        assertTrue((Integer)result[1].get(indexChemistry) == 1);
//    }
//
//                 @Test
//    public void testEKFP5() {
//        System.out.println("\n\ntestEKFP5");
//        String words = "to-day is today in British English.";
//        String ignoredWords = "today";
//        ArrayList[] result = search.extractKeywordsFromProblem(ignoredWords, words);
//        System.out.println(result[0]);
//        // changed assertTrue to assertFalse
//        assertFalse(result[0].contains("today"));
//        int indexChemistry = result[0].indexOf("today");
//
//        // added these two lines
//        assertTrue( indexChemistry == -1 );
//        assertEquals(result[0].size(), result[1].size());
//
//       // System.out.println("today occurrence: " + result[1].get(indexChemistry));
//       System.out.println("today occurrence: " + indexChemistry);
//
//    }
//}