///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package semanticprocessing;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
///**
// *
// * @author verarizvi
// */
//public class Search2Test {
//
//    public Search2Test() {
//    }
//    String problem = "how are you i am fine blah how how !! %^#%#& <>? : - _43 hi's     hi gir-ls girls'";
//    String ignorantWords = " are\n you\n blah!\n hello@\n";
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
//    }
//
//    @After
//    public void tearDown() {
//    }
//
//    /**
//     * Test of getInputKeywords method, of class Search2.
//     */
//    @Test
//    public void testGetInputKeywords() {
//        System.out.println("getInputKeywords");
//        String paragraph = problem;
//        String ignoredWords = ignorantWords;
//        HashMap result = Search.getInputKeywords(paragraph, ignoredWords);
//        assertFalse(result.containsKey("blah"));
//        assertFalse(result.containsKey("are"));
//        assertFalse(result.containsKey("you"));
//        assertTrue(result.containsKey("hi"));
//        assertTrue(result.containsKey("fine"));
//        assertTrue(result.containsKey("girl"));
//        assertTrue(result.containsKey("_43"));
//        assertTrue(result.containsKey("gir-ls"));
//        assertTrue(result.containsKey("i"));
//        assertTrue(result.containsKey("how"));
//        assertTrue(result.containsKey("am"));
//        int y = (Integer) (result.get("how"));
//        assertEquals(y, 3);
//        int d = (Integer) (result.get("am"));
//        assertEquals(d, 1);
//        int i = (Integer) (result.get("hi"));
//        assertEquals(i, 2);
//        int j = (Integer) (result.get("fine"));
//        assertEquals(j, 1);
//        int k = (Integer) (result.get("girl"));
//        assertEquals(k, 1);
//        int l = (Integer) (result.get("_43"));
//        assertEquals(l, 1);
//        int a = (Integer) (result.get("gir-ls"));
//        assertEquals(a, 1);
//        int h = (Integer) (result.get("i"));
//        assertEquals(h, 1);
//        Boolean res = (result.size() == 8);
//        assertTrue(res);
//
//    }
//
////    /**
////     * Test of deleteKeywords method, of class Search2.
////     */
////    @Test
////    public void testDeleteKeywords() {
////        HashMap wordMap = new HashMap<String, Integer>();
////
////        wordMap.put("how", 3);
////        wordMap.put("are", 1);
////        wordMap.put("you", 1);
////        wordMap.put("i", 1);
////        wordMap.put("am", 1);
////        wordMap.put("fine", 1);
////        wordMap.put("blah", 1);
////        wordMap.put("_43", 1);
////        wordMap.put("hi", 2);
////        wordMap.put("girl", 1);
////        wordMap.put("gir-ls", 1);
////
////        System.out.println("deleteKeywords");
////        String words = Search.deletePunc(ignorantWords);
////        HashMap result = Search.deleteKeywords(wordMap, words);
////        assertTrue(result.size() == 8);
////        assertTrue(result.equals(wordMap));
////        assertFalse(result.containsKey("blah"));
////        assertFalse(result.containsKey("are"));
////        assertFalse(result.containsKey("you"));
////        assertTrue(result.containsKey("hi"));
////        assertTrue(result.containsKey("fine"));
////        assertTrue(result.containsKey("girl"));
////        assertTrue(result.containsKey("_43"));
////        assertTrue(result.containsKey("gir-ls"));
////        assertTrue(result.containsKey("i"));
////        assertTrue(result.containsKey("how"));
////        assertTrue(result.containsKey("am"));
////        int y = (Integer) (result.get("how"));
////        assertEquals(y, 3);
////        int d = (Integer) (result.get("am"));
////        assertEquals(d, 1);
////        int i = (Integer) (result.get("hi"));
////        assertEquals(i, 2);
////        int j = (Integer) (result.get("fine"));
////        assertEquals(j, 1);
////        int k = (Integer) (result.get("girl"));
////        assertEquals(k, 1);
////        int l = (Integer) (result.get("_43"));
////        assertEquals(l, 1);
////        int a = (Integer) (result.get("gir-ls"));
////        assertEquals(a, 1);
////        int h = (Integer) (result.get("i"));
////        assertEquals(h, 1);
////
////    }
//
//    /**
//     * Test of deletePunc method, of class Search2.
//     */
//    @Test
//    public void testDeletePunc() {
//        System.out.println("deletePunc");
//        String string = problem;
//        String expResult = "how are you i am fine blah how how _43 hi hi gir-ls girl ";
//        String result = Search.deletePunc(string);
//        assertEquals(expResult, result);
//    }
//}
