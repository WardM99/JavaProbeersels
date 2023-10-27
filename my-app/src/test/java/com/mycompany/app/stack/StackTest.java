package com.mycompany.app.stack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.EmptyStackException;

import org.junit.Test;

public class StackTest {
    @Test
    public void basicTests(){
        StackInterface<Integer> s = new Stack<Integer>();
        s.push(5);
        s.push(6);

        int valuePeek = s.peek();
        int valuePop = s.pop();

        assertEquals(6, valuePeek);
        assertEquals(6, valuePop);

        assertTrue(valuePeek == valuePop);

        valuePeek = s.peek();
        assertEquals(5, valuePeek);
    }

    @Test
    public void peekEmptyStackTest(){
        StackInterface<Integer> s = new Stack<Integer>();
        Integer valuePeek = s.peek();

        assertNull(valuePeek);
    }
    @Test(expected = EmptyStackException.class)
    public void popEmptyStackTest(){
        StackInterface<Integer> s = new Stack<Integer>();
        s.pop();
    }
}
