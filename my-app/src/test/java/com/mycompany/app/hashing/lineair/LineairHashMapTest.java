package com.mycompany.app.hashing.lineair;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

public class LineairHashMapTest {
    @Test
    public void testGet(){
        LineairHashMap<String, Integer> h = 
            new LineairHashMap<String, Integer>();
        h.put("Zero", 0);
        h.put("One", 1);
        h.put("one", 1);
        h.put("Hey! How are you?", 10);

        int value = h.get("Zero");
        assertEquals(0,value);
        value = h.get("One");
        assertEquals(1,value);
        value = h.get("one");
        assertEquals(1,value);
        value = h.get("Hey! How are you?");
        assertEquals(10,value);
    }

    @Test
    public void testPutAndGetWithOverflow(){
        LineairHashMap<String, Integer> h = 
            new LineairHashMap<String, Integer>();
        List<String> numbersWrittenOut = new ArrayList<>(Arrays.asList(
            "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven",
            "Eight", "Nine",
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
            "Sixteen", "Seventeen", "Eighteen", "Nineteen",
            "Twenty", "Twenty-One", "Twenty-Two", "Twenty-Three", 
            "Twenty-Four", "Twenty-Five", "Twenty-Six", "Twenty-Seven",
            "Twenty-Eight", "Twenty-Nine",
            "Thirty", "Thirty-One", "Thirty-Two", "Thirty-Three",
            "Thirty-Four", "Thirty-Five", "Thirty-Six", "Thirty-Seven",
            "Thirty-Eight", "Thirty-Nine",
            "Forty", "Forty-One", "Forty-Two", "Forty-Three", "Forty-Four",
            "Forty-Five", "Forty-Six", "Forty-Seven", "Forty-Eight",
            "Forty-Nine","Fifty"
        ));

        for (int i = 0; i <= 50; i++) {
            h.put(numbersWrittenOut.get(i), i);
        }
        
        for (int i = 0; i <= 50; i++) {
            int value = h.get(numbersWrittenOut.get(i));
            assertEquals(i, value);
        }
    }

    @Test
    public void testGetOrDefault(){
        LineairHashMap<String, Integer> h = 
            new LineairHashMap<String, Integer>();
        h.put("Zero", 0);
        h.put("One", 1);
        h.put("one", 1);
        h.put("Hey! How are you?", 10);

        int value = h.getOrDefault("Zero", 6);
        assertEquals(0,value);
        value = h.getOrDefault("One", 6);
        assertEquals(1,value);
        value = h.getOrDefault("one", 6);
        assertEquals(1,value);
        value = h.getOrDefault("Hey! How are you?", 6);
        assertEquals(10,value);
        value = h.getOrDefault("Hey, How are you?", 6);
        assertEquals(6,value);
    }

    @Test
    public void testRemoveKey(){
        LineairHashMap<String, Integer> h = 
            new LineairHashMap<String, Integer>();
        h.put("Zero", 0);
        h.put("One", 1);
        h.put("one", 1);
        h.put("Hey! How are you?", 10);

        int value = h.get("Zero");
        assertEquals(0,value);

        h.remove("Zero");
        assertThrows(NoSuchElementException.class, () -> {
            h.get("Zero");
        });
    }

    @Test
    public void testRemoveKeyAndValue(){
        LineairHashMap<String, Integer> h = 
            new LineairHashMap<String, Integer>();
        h.put("Zero", 0);
        h.put("One", 1);
        h.put("one", 1);
        h.put("Hey! How are you?", 10);

        int value = h.get("Zero");
        assertEquals(0,value);

        h.remove("Zero",0);
        assertThrows(NoSuchElementException.class, () -> {
            h.get("Zero");
        });
    }

    @Test
    public void testRemoveKeyDontExcist(){
        LineairHashMap<String, Integer> h = 
            new LineairHashMap<String, Integer>();
        h.put("Zero", 0);
        h.put("One", 1);
        h.put("one", 1);
        h.put("Hey! How are you?", 10);
        assertThrows(NoSuchElementException.class, () -> {
            h.remove("zero");
        });
    } 
    
    @Test
    public void testRemoveKeyDontExcistWithValue(){
        LineairHashMap<String, Integer> h = 
            new LineairHashMap<String, Integer>();
        h.put("Zero", 0);
        h.put("One", 1);
        h.put("one", 1);
        h.put("Hey! How are you?", 10);
        assertThrows(NoSuchElementException.class, () -> {
            h.remove("Zero", 3);
        });
    }

    @Test
    public void testContainsKey(){
        LineairHashMap<String, Integer> h = 
            new LineairHashMap<String, Integer>();
        h.put("Zero", 0);
        h.put("One", 1);
        h.put("one", 1);
        h.put("Hey! How are you?", 10);

        assertTrue(h.containsKey("Zero"));
        assertTrue(h.containsKey("One"));
        assertTrue(h.containsKey("one"));
        assertTrue(h.containsKey("Hey! How are you?"));
        assertFalse(h.containsKey("Hey, How are you?"));

        h.remove("one");

        assertFalse(h.containsKey("one"));
    }

    @Test
    public void testDublicate(){
        LineairHashMap<String, Integer> h = 
            new LineairHashMap<String, Integer>();

        h.put("Zero", 0);

        assertEquals(Integer.valueOf(0), h.get("Zero"));

        h.put("Zero", 10);

        assertEquals(Integer.valueOf(10), h.get("Zero"));
    }
}
