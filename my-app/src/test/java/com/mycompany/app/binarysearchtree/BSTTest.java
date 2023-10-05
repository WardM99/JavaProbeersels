package com.mycompany.app.binarysearchtree;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BSTTest {
    @Test
    public void makeBST(){
        new BST<Integer>();
    }
    @Test 
    public void testAdd(){
        BSTInterface<Integer> b = new BST<Integer>();
        b.add(5);
    }
    @Test 
    public void testAddMultiple(){
        BSTInterface<Integer> b = new BST<Integer>();
        b.add(5);
        b.add(6);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddDublicate(){
        BSTInterface<Integer> b = new BST<Integer>();
        b.add(5);
        b.add(5);
    }
    @Test
    public void testContains(){
        BSTInterface<Integer> b = new BST<Integer>();
        assertFalse(b.contains(5));
        b.add(5);
        assertTrue(b.contains(5));
        b.add(1);
        assertTrue(b.contains(1));
        b.add(10);
        assertTrue(b.contains(10));
        b.add(6);
        assertTrue(b.contains(6));
    }
    @Test
    public void testDontContains(){
        BSTInterface<Integer> b = new BST<Integer>();
        b.add(5);
        b.add(1);
        b.add(10);
        b.add(6);
        assertFalse(b.contains(9));
    }
}
