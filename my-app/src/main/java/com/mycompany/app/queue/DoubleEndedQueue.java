package com.mycompany.app.queue;

import java.util.EmptyStackException;

import com.mycompany.app.linkedlist.Node;

public class DoubleEndedQueue<T> implements DoubleEndedQueueInterface<T> {

    Node<T> head;

    Node<T> tail;

    public DoubleEndedQueue(){
        this.head = null;
        this.tail = null;
    }

    @Override
    public void pushBack(T value) {
        Node<T> newNode = new Node<T>(value);
        if(this.head == null){
            this.head = newNode;
        }
        if(this.tail != null){
            this.tail.setNextNode(newNode);
        }

        this.tail = newNode;
    }

    @Override
    public void pushFront(T value) {
        Node<T> newNode = new Node<T>(value);
        if(this.tail == null){
            this.tail = newNode;
        }
        newNode.setNextNode(this.head);
        this.head = newNode;
    }

    @Override
    public T popBack() throws EmptyStackException {
        if(this.tail == null)
            throw new EmptyStackException();
        T value = this.tail.getValue();
        Node<T> prev = null;
        Node<T> current = this.head;

        while (!current.equals(this.tail)) {
            prev = current;
            current = current.getNextNode();
        }
        
        this.tail = prev;

        if(this.tail == null)
            this.head = null;

        return value;
    }

    @Override
    public T popFront() throws EmptyStackException {
        if(this.head == null)
            throw new EmptyStackException();
        T value = this.head.getValue();
        this.head = this.head.getNextNode();

        if(this.head == null)
            this.tail = null;

        return value;
    }

    @Override
    public T peekBack() {
        return this.tail.getValue();
    }

    @Override
    public T peekFront() {
        return this.head.getValue();
    }
    
}
