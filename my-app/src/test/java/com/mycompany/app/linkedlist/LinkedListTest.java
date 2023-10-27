package com.mycompany.app.linkedlist;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.NoSuchElementException;

import org.junit.Test;

public class LinkedListTest {
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
    @Test(expected = NoSuchElementException.class)
    public void removeElementThatDontExcist(){
        LinkedListInterface<Integer> l = new LinkedList<Integer>();
        l.add(5);
        l.add(6);
        l.add(7);
        assertTrue(l.size()==3);
        assertFalse(l.contains(10));
        l.remove(10);
        assertTrue(l.size()==3);
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
    public void testGetNextMultipleWithRemove(){
        LinkedListInterface<Integer> l = new LinkedList<Integer>();
        l.add(5);
        l.add(6);
        l.add(7);
        l.add(8);
        l.add(9);
        Integer n = l.getNext();
        assertTrue(n.equals(5));
        l.remove(6);
        n = l.getNext();
        assertFalse(n.equals(6));
        assertTrue(n.equals(7));
    }
    @Test
    public void testGetNextRemoveHead(){
        LinkedListInterface<Integer> l = new LinkedList<Integer>();
        l.add(5);
        l.add(6);
        l.add(7);
        l.add(8);
        l.add(9);
        Integer n = l.getNext();
        assertTrue(n.equals(5));
        l.remove(5);
        n = l.getNext();
        assertTrue(n.equals(6));
    }
    @Test
    public void testGetNextRemoveLast(){
        LinkedListInterface<Integer> l = new LinkedList<Integer>();
        l.add(5);
        l.add(6);
        l.add(7);
        l.add(8);
        l.add(9);
        Integer n = 0;
        for(int i = 0; i < 4; i++)
            n = l.getNext();
        l.remove(9);
        n = l.getNext();
        assertFalse(n.equals(9));
        assertTrue(n.equals(5));
    }
    @Test
    public void testReverseLinkedList(){
        LinkedListInterface<Integer> l = new LinkedList<Integer>();
        for(int i = 5; i <= 8; i++)
            l.add(i);
        l.reverseLinkedList();
        Integer n = 0;
        for(int i = 8; i >= 5; i--){
            n = l.getNext();
            assertTrue(n == i);
        }
    }
    @Test
    public void testSize(){
        LinkedListInterface<Integer> l = new LinkedList<Integer>();
        l.add(5);
        l.add(6);
        l.add(7);
        l.add(8);
        l.add(9);
        assertTrue(l.size()==5);
        l.add(2);
        assertTrue(l.size()==6);
        l.remove(6);
        assertTrue(l.size()==5);
        l.remove(5);
        assertTrue(l.size()==4);
    }
    @Test
    public void testGetAt(){
        LinkedListInterface<Integer> l = new LinkedList<Integer>();
        l.add(5);
        l.add(6);
        l.add(7);
        l.add(8);
        l.add(9);
        assertTrue(l.getAt(0).equals(5));
        assertTrue(l.getAt(2).equals(7));
        assertTrue(l.getAt(4).equals(9));
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetAtGiveIndexOutOfBoundException(){
        LinkedListInterface<Integer> l = new LinkedList<Integer>();
        l.add(5);
        l.add(6);
        l.add(7);
        l.add(8);
        l.add(9);
        l.getAt(10);
    }
}
