package com.mycompany.app.binarysearchtree;

import org.junit.Test;

public class BSTTest {
    @Test
    public void makeBST(){
        new BST<Integer>();
    }
    @Test 
    public void testAdd(){
        BSTInterface<Integer> b = new BST<Integer>();
        b.add(5);
    }
}
