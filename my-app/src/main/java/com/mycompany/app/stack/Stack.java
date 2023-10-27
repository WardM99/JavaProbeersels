package com.mycompany.app.stack;

import java.util.EmptyStackException;

import com.mycompany.app.linkedlist.Node;

public class Stack<T> implements StackInterface<T> {

    Node<T> head;

    public Stack(){
        this.head = null;
    }

    @Override
    public void push(T value) {
        Node<T> newNode = new Node<T>(value);
        newNode.setNextNode(this.head);
        this.head = newNode;
    }
    @Override
    public T pop() throws EmptyStackException {
        if(this.head == null)
            throw new EmptyStackException();
        
        T value = this.head.getValue();
        this.head = this.head.getNextNode();
        return value;
    }

    @Override
    public T peek() {
        if(this.head == null)
            return null;
        return this.head.getValue();
    }
    
}
