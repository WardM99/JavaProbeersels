package com.mycompany.app.hashing.lineair;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BucketItemTest {
    @Test
    public void equalsBucketItems(){
        BucketItem<String, Integer> bi1 =
            new BucketItem<String,Integer>("TEST", 5);
        BucketItem<String, Integer> bi2 =
            new BucketItem<String,Integer>("TEST", 6);
        BucketItem<String, Integer> bi3 =
            new BucketItem<String,Integer>("LEST", 5);
        BucketItem<String, Integer> bi4 =
            new BucketItem<String,Integer>("LEST", 6);
        BucketItem<String, Integer> bi5 =
            new BucketItem<String,Integer>("TEST", 5);
        assertEquals(bi1, bi2);
        assertNotEquals(bi1, bi3);
        assertNotEquals(bi1, bi4);
        assertEquals(bi1, bi5);
    }
}
