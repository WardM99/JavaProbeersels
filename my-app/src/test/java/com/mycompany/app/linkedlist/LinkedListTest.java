package com.mycompany.app.linkedlist;


import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public void removeElementThatDontExcist(){
        LinkedListInterface<Integer> l = new LinkedList<Integer>();
        l.add(5);
        l.add(6);
        l.add(7);
        assertEquals(3, l.size());
        assertFalse(l.contains(10));
        assertThrows(NoSuchElementException.class, () -> {
            l.remove(10);
        });
        assertEquals(3, l.size());
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
        assertNull(n);
    }

    @Test
    public void testGetNext(){
        LinkedListInterface<Integer> l = new LinkedList<Integer>();
        l.add(5);
        Integer n = l.getNext();
        assertEquals(5, (int) n);
    }

    @Test
    public void testGetNextMultiple(){
        LinkedListInterface<Integer> l = new LinkedList<Integer>();
        l.add(5);
        l.add(6);
        Integer n = l.getNext();
        assertEquals(5, (int) n);
        n = l.getNext();
        assertEquals(6, (int) n);
        n = l.getNext();
        assertEquals(5, (int) n);
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
        assertEquals(5, (int) n);
        l.remove(6);
        n = l.getNext();
        assertNotEquals(6, (int) n);
        assertEquals(7, (int) n);
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
        assertEquals(5, (int) n);
        l.remove(5);
        n = l.getNext();
        assertEquals(6, (int) n);
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
        assertNotEquals(9, (int) n);
        assertEquals(5, (int) n);
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
            assertEquals((int) n, i);
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
        assertEquals(5, l.size());
        l.add(2);
        assertEquals(6, l.size());
        l.remove(6);
        assertEquals(5, l.size());
        l.remove(5);
        assertEquals(4, l.size());
    }

    @Test
    public void testGetAt(){
        LinkedListInterface<Integer> l = new LinkedList<Integer>();
        l.add(5);
        l.add(6);
        l.add(7);
        l.add(8);
        l.add(9);
        assertEquals(5, (int) l.getAt(0));
        assertEquals(7, (int) l.getAt(2));
        assertEquals(9, (int) l.getAt(4));
    }
    
    @Test
    public void testGetAtGiveIndexOutOfBoundException(){
        LinkedListInterface<Integer> l = new LinkedList<Integer>();
        l.add(5);
        l.add(6);
        l.add(7);
        l.add(8);
        l.add(9);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            l.getAt(10);
        });
    }
}
