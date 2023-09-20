package com.mycompany.app.linkedlist;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LinkedListTest {
    @Test
    public void makeLinkedList() {
        new LinkedList<Integer>();
    }
    @Test 
    public void emptyContainsNothing() {
        LinkedList<Integer> l = new LinkedList<Integer>();
        assertFalse(l.contains(5));
    }
    @Test
    public void addOneElement() {
        LinkedList<Integer> l = new LinkedList<Integer>();
        l.add(5);
        assertTrue(l.contains(5));
    }
    @Test
    public void addTwoElements() {
        LinkedList<Integer> l = new LinkedList<Integer>();
        l.add(5);
        l.add(6);
        assertTrue(l.contains(5));
        assertTrue(l.contains(6));
    }
}
