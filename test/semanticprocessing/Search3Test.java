///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//
//package semanticprocessing;
//
//import java.util.HashMap;
//import java.io.IOException;
//import java.net.URL;
//import org.junit.AfterClass;
//import org.junit.BeforeClass;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
///**
// *
// * @author c9edghai
// */
//public class Search3Test {
//    HashMap<String, Integer> keyWords;
//    Search search;
//    FacultyMember fm;
//    boolean temp;
//
//    public Search3Test() {
//    }
//
//    @BeforeClass
//    public static void startTests() {
//        System.out.println("STARTING TESTS: ");
//    }
//
//    @AfterClass
//    public static void endTests() {
//        System.out.println("ENDING TESTS.");
//    }
//
//    @Before
//    public void setUp() throws NotAnHtmlUrlException, IOException {
//        System.out.print("\tTest: ");
//        fm = new FacultyMember
//                (new URL("http://www.cdf.toronto.edu/~csc207h/fall/"));
//        keyWords = new HashMap<String, Integer>();
//
//
//    }
//
//    @After
//    public void tearDown() {
//        System.out.println("- COMPLETED.");
//    }
//
//    @Test
//    public void testGetMemberScore() {
//        System.out.print("getMemberScore()");
//        keyWords.put("warmup", 10);
//        int score = Search.getMemberScore(fm, keyWords);
//        assertEquals(score,10);
//        keyWords.put("elephant", 1);
//        keyWords.put("car", 4);
//        keyWords.put("landlord", 5);
//        keyWords.put("food", 3);
//        score = Search.getMemberScore(fm, keyWords);
//        assertEquals(score,20);
//        keyWords.put("software", 3);
//        score = Search.getMemberScore(fm, keyWords);
//        assertEquals(score,38);
//        keyWords.put("textbooks", 9);
//        score = Search.getMemberScore(fm, keyWords);
//        assertEquals(score,47);
//
//
//    }
//
//    @Test
//    public void testGMSwithBadValues() {
//        System.out.print("GMS with BadValues");
//        keyWords.put("elasdfasdfant", 1);
//        keyWords.put("caasdfasdfr", 4);
//        keyWords.put("lanasfhajdlord", 5);
//        keyWords.put("food2sdgasdg", 3);
//        int score = Search.getMemberScore(fm, keyWords);
//        assertEquals(score,0);
//    }
//
//}