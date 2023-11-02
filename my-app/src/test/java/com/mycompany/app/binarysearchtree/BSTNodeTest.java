package com.mycompany.app.binarysearchtree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BSTNodeTest {
    @Test
    public void getCorrectValue(){
        BSTNodeInterface<Integer> n = new BSTNode<Integer>(5);
        assertEquals(5, n.getValue());
    }
    
    @Test
    public void getAndSetChilderen(){
        BSTNodeInterface<Integer> n = new BSTNode<Integer>(5);
        BSTNodeInterface<Integer> l = new BSTNode<Integer>(4);
        BSTNodeInterface<Integer> r = new BSTNode<Integer>(6);

        n.setLeftChild(l);
        n.setRightChild(r);

        assertEquals(4, n.getLeftChild().getValue());
        assertEquals(6, n.getRightChild().getValue());
    }
}
