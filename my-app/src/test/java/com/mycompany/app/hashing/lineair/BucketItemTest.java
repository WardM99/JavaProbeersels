package com.mycompany.app.hashing.lineair;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class BucketItemTest {
    @Test
    public void makeBucketItem(){
        new BucketItem<String,Integer>("TEST", 5);
    }
    @Test
    public void equalsBucketItems(){
        BucketItem<String, Integer> bi1 = new BucketItem<String,Integer>("TEST", 5);
        BucketItem<String, Integer> bi2 = new BucketItem<String,Integer>("TEST", 6);
        BucketItem<String, Integer> bi3 = new BucketItem<String,Integer>("LEST", 5);
        BucketItem<String, Integer> bi4 = new BucketItem<String,Integer>("LEST", 6);
        BucketItem<String, Integer> bi5 = new BucketItem<String,Integer>("TEST", 5);
        assertTrue(bi1.equals(bi2));
        assertFalse(bi1.equals(bi3));
        assertFalse(bi1.equals(bi4));
        assertTrue(bi1.equals(bi5));
    }
}
