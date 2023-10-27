package com.mycompany.app.stack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.EmptyStackException;

import org.junit.Before;
import org.junit.Test;

public class StackTest {
    private Stack<Integer> s;

    @Before
    public void setUp() {
        s = new Stack<>();
    }
    @Test
    public void basicTests(){
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
        Integer valuePeek = s.peek();

        assertNull(valuePeek);
    }
    @Test(expected = EmptyStackException.class)
    public void popEmptyStackTest(){
        s.pop();
    }
    @Test
    public void testPushAndPopMixed() {
        s.push(100);
        s.push(200);
        assertEquals(200, s.pop().intValue());
        s.push(300);
        assertEquals(300, s.pop().intValue());
        assertEquals(100, s.pop().intValue());
    }
}
