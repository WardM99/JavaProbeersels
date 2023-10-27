package com.mycompany.app.queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.EmptyStackException;

import org.junit.Before;
import org.junit.Test;

public class QueueTest {
    private QueueInterface<Integer> q;

    @Before
    public void setUp(){
        q = new Queue<Integer>();
    }

    @Test
    public void basicTests(){
        q.enqueue(5);
        q.enqueue(6);
        q.enqueue(7);
        q.enqueue(8);
        q.enqueue(9);

        int valuePeek = q.peek();
        int valuePop = q.dequeue();

        assertEquals(5, valuePeek);
        assertEquals(5, valuePop);

        assertTrue(valuePeek == valuePop);

        valuePeek = q.peek();
        assertEquals(6, valuePeek);
    }
    
    @Test
    public void peekEmptyStackTest(){
        Integer valuePeek = q.peek();

        assertNull(valuePeek);
    }

    @Test(expected = EmptyStackException.class)
    public void popEmptyStackTest(){
        q.dequeue();
    }
}
