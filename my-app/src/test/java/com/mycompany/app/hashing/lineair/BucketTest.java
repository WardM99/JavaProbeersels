package com.mycompany.app.hashing.lineair;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class BucketTest {
    @Test
    public void containsItems(){
        Bucket<String, Integer> b = new Bucket<String, Integer>(2);
        b.add("Test", 5);
        b.add("Lest", 6);

        assertTrue(b.contains("Test"));
        assertTrue(b.contains("Lest"));
    }

    @Test
    public void addItemsOverflow(){
        Bucket<String, Integer> b = new Bucket<String, Integer>(2);
        b.add("Test", 5);
        b.add("Lest", 6);
        b.add("Kest", 10);

        assertTrue(b.contains("Test"));
        assertTrue(b.contains("Lest"));
        assertTrue(b.contains("Kest"));
    }

    @Test
    public void removeItems(){
        Bucket<String, Integer> b = new Bucket<String, Integer>(2);
        b.add("Test", 5);
        b.add("Lest", 6);

        assertTrue(b.contains("Test"));
        assertTrue(b.contains("Lest"));

        b.remove("Test");

        assertFalse(b.contains("Test"));
        assertTrue(b.contains("Lest"));
    }

    @Test
    public void removeItemsOverflow(){
        Bucket<String, Integer> b = new Bucket<String, Integer>(2);
        b.add("Test", 5);
        b.add("Lest", 6);
        b.add("Kest", 10);

        assertTrue(b.contains("Test"));
        assertTrue(b.contains("Lest"));
        assertTrue(b.contains("Kest"));

        b.remove("Kest");

        assertTrue(b.contains("Test"));
        assertTrue(b.contains("Lest"));
        assertFalse(b.contains("Kest"));
    }

    @Test
    public void getItem(){
        Bucket<String, Integer> b = new Bucket<String, Integer>(2);
        b.add("Test", 5);
        b.add("Lest", 6);
        b.add("Kest", 10);

        int value = b.get("Test");
        assertEquals(5,value);
        value = b.get("Lest");
        assertEquals(6,value);
        value = b.get("Kest");
        assertEquals(10,value);
    }

}
