package com.mycompany.app.linkedlist.fixedsize;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

import com.mycompany.app.linkedlist.LinkedListInterface;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListFixedSizeTest {
    @Test 
    public void emptyContainsNothing() {
        LinkedListInterface<Integer> l = new LinkedListFixedSize<Integer>(10);
        assertFalse(l.contains(5));
    }

    @Test
    public void addOneElement() {
        LinkedListInterface<Integer> l = new LinkedListFixedSize<Integer>(10);
        l.add(5);
        assertTrue(l.contains(5));
        assertFalse(l.contains(6));
    }
    
    @Test
    public void addTwoElements() {
        LinkedListInterface<Integer> l = new LinkedListFixedSize<Integer>(10);
        l.add(5);
        l.add(6);
        assertTrue(l.contains(5));
        assertTrue(l.contains(6));
    }

    @Test
    public void removeElement(){
        LinkedListInterface<Integer> l = new LinkedListFixedSize<Integer>(10);
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
        LinkedListInterface<Integer> l = new LinkedListFixedSize<Integer>(10);
        l.add(5);
        l.add(6);
        l.add(7);
        assertFalse(l.contains(10));
        assertThrows(NoSuchElementException.class, () -> {
            l.remove(10);
        });
    }

    @Test
    public void removeHeadElement(){
        LinkedListInterface<Integer> l = new LinkedListFixedSize<Integer>(10);
        l.add(5);
        l.add(6);
        l.remove(5);
        assertFalse(l.contains(5));
        assertTrue(l.contains(6));
    }

    @Test
    public void testGetNextNothing(){
        LinkedListInterface<Integer> l = new LinkedListFixedSize<Integer>(10);
        Integer n = l.getNext();
        assertNull(n);
    }

    @Test
    public void testGetNext(){
        LinkedListInterface<Integer> l = new LinkedListFixedSize<Integer>(10);
        l.add(5);
        Integer n = l.getNext();
        assertEquals(5, (int) n);
    }

    @Test
    public void testGetNextMultiple(){
        LinkedListInterface<Integer> l = new LinkedListFixedSize<Integer>(10);
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
        LinkedListInterface<Integer> l = new LinkedListFixedSize<Integer>(10);
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
        LinkedListInterface<Integer> l = new LinkedListFixedSize<Integer>(10);
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
        LinkedListInterface<Integer> l = new LinkedListFixedSize<Integer>(10);
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
        LinkedListInterface<Integer> l = new LinkedListFixedSize<Integer>(4);
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
        LinkedListInterface<Integer> l = new LinkedListFixedSize<Integer>(10);
        l.add(5);
        l.add(6);
        l.add(7);
        l.add(8);
        l.add(9);
        assertEquals(10, l.size());
        l.add(2);
        assertEquals(10, l.size());
        l.remove(6);
        assertEquals(10, l.size());
        l.remove(5);
        assertEquals(10, l.size());
    }

    @Test
    public void testGetAt(){
        LinkedListInterface<Integer> l = new LinkedListFixedSize<Integer>(10);
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
        LinkedListInterface<Integer> l = new LinkedListFixedSize<Integer>(10);
        l.add(5);
        l.add(6);
        l.add(7);
        l.add(8);
        l.add(9);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            l.getAt(10);
        });
       
    }

    @Test
    public void testMoreThen10(){
        LinkedListInterface<Integer> l = new LinkedListFixedSize<>(10);
        for(int i = 0; i < 10; i++){
            l.add(i);
        }
        for(int i = 0; i < 10; i++){
            assertTrue(l.contains(i));
        }
        l.add(120);
        assertFalse(l.contains(120));
    }

    @Test
    public void testIsFull(){
        LinkedListFixedSize<Integer> l = new LinkedListFixedSize<>(10);
        for(int i = 0; i < 10; i++){
            l.add(i);
        }
        assertTrue(l.isFull());
    }
    
    @Test
    public void testIsNotFull(){
        LinkedListFixedSize<Integer> l = new LinkedListFixedSize<>(10);
        for(int i = 0; i < 10; i++){
            l.add(i);
        }
        l.remove(6);
        assertFalse(l.isFull());
    }
}
