package com.mycompany.app.queue;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class DoubleEndedQueueTest {
    private DoubleEndedQueueInterface<Integer> queue;

    @Before
    public void setUp(){
        queue = new DoubleEndedQueue<Integer>();
    }

    @Test
    public void testPushAndPopBack() {

        queue.pushBack(1);
        queue.pushBack(2);

        assertEquals(Integer.valueOf(2), queue.popBack());
        assertEquals(Integer.valueOf(1), queue.popBack());
    }

    @Test
    public void testPushAndPopFront() {
        
        queue.pushFront(10);
        queue.pushFront(5);

        assertEquals(Integer.valueOf(10), queue.popFront());
        assertEquals(Integer.valueOf(5), queue.popFront());
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

        assertEquals(Double.valueOf(3), queue.peekFront());
        assertEquals(Double.valueOf(3), queue.peekFront());
    }
}
