package com.mycompany.app.binarysearchtree;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BSTNodeTest {
    @Test
    public void makeBSTNode(){
        new BSTNode<Integer>(5);
    }
    @Test
    public void getCorrectValue(){
        BSTNodeInterface<Integer> n = new BSTNode<Integer>(5);
        assertTrue(n.getValue().equals(5));
    }
    @Test
    public void getAndSetChilderen(){
        BSTNodeInterface<Integer> n = new BSTNode<Integer>(5);
        BSTNodeInterface<Integer> l = new BSTNode<Integer>(4);
        BSTNodeInterface<Integer> r = new BSTNode<Integer>(6);

        n.setLeftChild(l);
        n.setRightChild(r);

        assertTrue(n.getLeftChild().getValue().equals(4));
        assertTrue(n.getRightChild().getValue().equals(6));
    }
}
