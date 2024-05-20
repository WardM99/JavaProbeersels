package com.mycompany.app.queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.EmptyStackException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class QueueTest {
    private QueueInterface<Integer> q;

    @BeforeEach
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

    @Test
    public void popEmptyStackTest(){
        assertThrows(EmptyStackException.class, () -> {
            q.dequeue();
        });
    }
}
