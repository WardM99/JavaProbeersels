package com.mycompany.app.queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.EmptyStackException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class DoubleEndedQueueTest {
    private DoubleEndedQueueInterface<Integer> queue;

    @BeforeEach
    public void setUp(){
        queue = new DoubleEndedQueue<Integer>();
    }

    @Test
    public void testEmptyPopBack(){
        assertThrows(EmptyStackException.class, () -> {
            queue.popBack();
        });
    }

    @Test
    public void testEmptyPopFront(){
        assertThrows(EmptyStackException.class, () -> {
            queue.popFront();
        });
    }

    @Test
    public void testPushAndPopBack() {

        queue.pushBack(1);
        queue.pushBack(2);

        assertEquals(Integer.valueOf(2), queue.popBack());
        assertEquals(Integer.valueOf(1), queue.popBack());
    }

    @Test
    public void testPushBackAndPopFront() {

        queue.pushBack(1);
        queue.pushBack(2);

        assertEquals(Integer.valueOf(1), queue.popFront());
        assertEquals(Integer.valueOf(2), queue.popFront());
    }

    @Test
    public void testPushAndPopFront() {
        
        queue.pushFront(10);
        queue.pushFront(5);

        assertEquals(Integer.valueOf(5), queue.popFront());
        assertEquals(Integer.valueOf(10), queue.popFront());
    }

    @Test
    public void testPushFrontAndPopBack() {
        
        queue.pushFront(10);
        queue.pushFront(5);

        assertEquals(Integer.valueOf(10), queue.popBack());
        assertEquals(Integer.valueOf(5), queue.popBack());
    }

    @Test
    public void testPeekBack() {
        queue.pushBack(1);
        queue.pushBack(2);

        assertEquals(Integer.valueOf(2), queue.peekBack());
        assertEquals(Integer.valueOf(2), queue.peekBack());
    }

    @Test
    public void testPeekFront() {

        queue.pushFront(3);
        queue.pushFront(2);

        assertEquals(Integer.valueOf(2), queue.peekFront());
        assertEquals(Integer.valueOf(2), queue.peekFront());
    }

    @Test
    public void testPushAndPopFrontAndPopBack() {
        
        queue.pushFront(10);
        queue.pushFront(5);

        assertEquals(Integer.valueOf(5), queue.popFront());
        assertEquals(Integer.valueOf(10), queue.popFront());

        assertThrows(EmptyStackException.class, () -> {
            queue.popBack();
        });
    }

    @Test
    public void testPushAndPopBackAndPopFront() {

        queue.pushBack(1);
        queue.pushBack(2);

        assertEquals(Integer.valueOf(2), queue.popBack());
        assertEquals(Integer.valueOf(1), queue.popBack());
        
        assertThrows(EmptyStackException.class, () -> {
            queue.popFront();
        });
    }
}
