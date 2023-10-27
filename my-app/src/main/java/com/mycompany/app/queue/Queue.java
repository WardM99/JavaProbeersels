package com.mycompany.app.queue;

import java.util.EmptyStackException;

import com.mycompany.app.linkedlist.Node;

public class Queue<T> implements QueueInterface<T> {

    Node<T> head;
    
    Node<T> tail;

    public Queue(){
        this.head = null;
        this.tail = null;
    }

    @Override
    public void enqueue(T value) {
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
    public T dequeue() {
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
