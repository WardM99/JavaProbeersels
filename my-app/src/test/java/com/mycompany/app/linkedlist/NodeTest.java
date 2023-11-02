package com.mycompany.app.linkedlist;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class NodeTest {
    @Test
    public void getCorrectValue(){
        Node<Integer> n = new Node<Integer>(5);
        assertTrue(n.getValue().equals(5));
        assertTrue(!n.getValue().equals(6));
    }
    
    @Test
    public void setNextNode(){
        Node<Integer> n1 = new Node<Integer>(5);
        Node<Integer> n2 = new Node<Integer>(10);
        n1.setNextNode(n2);
        assertTrue(n1.getNextNode().equals(n2));
    }
}
