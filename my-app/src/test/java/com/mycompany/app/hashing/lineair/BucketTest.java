package com.mycompany.app.hashing.lineair;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BucketTest {
    @Test
    public void makeBucket(){
        new Bucket<String, Integer>(2);
    }
    @Test
    public void addItems(){
        Bucket<String, Integer> b = new Bucket<String, Integer>(2);
        b.add("Test", 5);
        b.add("Lest", 6);
    }

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

}
