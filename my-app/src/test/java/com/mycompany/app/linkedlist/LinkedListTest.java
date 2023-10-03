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
        assertFalse(l.contains(6));
    }
    @Test
    public void addTwoElements() {
        LinkedListInterface<Integer> l = new LinkedList<Integer>();
        l.add(5);
        l.add(6);
        assertTrue(l.contains(5));
        assertTrue(l.contains(6));
    }
    @Test
    public void removeElement(){
        LinkedListInterface<Integer> l = new LinkedList<Integer>();
        l.add(5);
        l.add(6);
        l.add(7);
        l.remove(6);
        assertFalse(l.contains(6));
        assertTrue(l.contains(5));
        assertTrue(l.contains(7));
    }
    @Test
    public void removeHeadElement(){
        LinkedListInterface<Integer> l = new LinkedList<Integer>();
        l.add(5);
        l.add(6);
        l.remove(5);
        assertFalse(l.contains(5));
        assertTrue(l.contains(6));
    }
    @Test
    public void testGetNextNothing(){
        LinkedListInterface<Integer> l = new LinkedList<Integer>();
        Integer n = l.getNext();
        assertTrue(n==null);
    }
    @Test
    public void testGetNext(){
        LinkedListInterface<Integer> l = new LinkedList<Integer>();
        l.add(5);
        Integer n = l.getNext();
        assertTrue(n.equals(5));
    }
    @Test
    public void testGetNextMultiple(){
        LinkedListInterface<Integer> l = new LinkedList<Integer>();
        l.add(5);
        l.add(6);
        Integer n = l.getNext();
        assertTrue(n.equals(5));
        n = l.getNext();
        assertTrue(n.equals(6));
        n = l.getNext();
        assertTrue(n.equals(5));
    }
    @Test
    public void testSort(){
        LinkedListInterface<Integer> l = new LinkedList<Integer>();
        l.add(45);
        l.add(23);
        l.add(98);
        l.add(17);
        l.add(65);
        l.add(89);
        l.add(100);
        l.add(34);
        l.add(78);
        l.add(56);
        l.sort();
    }
}
