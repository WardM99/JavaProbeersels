package com.mycompany.app.binarysearchtree;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.NoSuchElementException;

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
    @Test
    public void testRemove(){
        BSTInterface<Integer> b = new BST<Integer>();
        b.add(5);
        b.add(3);
        b.add(7);
        b.add(2);
        b.add(4);
        b.add(6);
        b.add(8);
        assertTrue(b.contains(5));
        b.remove(5);
        assertFalse(b.contains(5));
        assertTrue(b.contains(6));
        assertTrue(b.contains(3));
        assertTrue(b.contains(2));
        assertTrue(b.contains(4));
        assertTrue(b.contains(7));
        assertTrue(b.contains(8));
    }
    @Test
    public void testRemoveExtraChild(){
        BSTInterface<Integer> b = new BST<Integer>();
        b.add(50);
        b.add(30);
        b.add(70);
        b.add(20);
        b.add(40);
        b.add(60);
        b.add(80);
        b.add(65);
        assertTrue(b.contains(50));
        b.remove(50);
        assertFalse(b.contains(50));
        assertTrue(b.contains(60));
        assertTrue(b.contains(30));
        assertTrue(b.contains(20));
        assertTrue(b.contains(40));
        assertTrue(b.contains(70));
        assertTrue(b.contains(80));
        assertTrue(b.contains(65));
    }public void testRemoveExtraChildOtherSide(){
        BSTInterface<Integer> b = new BST<Integer>();
        b.add(50);
        b.add(30);
        b.add(70);
        b.add(20);
        b.add(40);
        b.add(60);
        b.add(80);
        b.add(35);
        assertTrue(b.contains(50));
        b.remove(50);
        assertFalse(b.contains(50));
        assertTrue(b.contains(60));
        assertTrue(b.contains(30));
        assertTrue(b.contains(20));
        assertTrue(b.contains(40));
        assertTrue(b.contains(70));
        assertTrue(b.contains(80));
        assertTrue(b.contains(35));
    }
    @Test(expected = NoSuchElementException.class)
    public void testRemoveDontExcist(){
        BSTInterface<Integer> b = new BST<Integer>();
        b.add(5);
        b.add(1);
        b.add(10);
        b.add(6);
        assertFalse(b.contains(50));
        b.remove(50);
    }
}
