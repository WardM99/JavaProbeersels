package com.mycompany.app.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NodeTest {
    @Test
    public void getCorrectValue(){
        Node<Integer> n = new Node<Integer>(5);
        assertEquals(5, (int) n.getValue());
        assertFalse(n.getValue().equals(6));
    }
    
    @Test
    public void setNextNode(){
        Node<Integer> n1 = new Node<Integer>(5);
        Node<Integer> n2 = new Node<Integer>(10);
        n1.setNextNode(n2);
        assertEquals(n1.getNextNode(), n2);
    }
}
