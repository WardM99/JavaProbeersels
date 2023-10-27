package com.mycompany.app.linkedlist.fixedsize;

import java.util.NoSuchElementException;

import com.mycompany.app.linkedlist.LinkedListInterface;
import com.mycompany.app.linkedlist.Node;

public class LinkedListFixedSize<T> implements LinkedListInterface<T> {
    
    private Node<T> head;
    private Node<T> currentNode;
    private int size;
    public LinkedListFixedSize(int size){
        this.size = size;
        this.head = new Node<T>(null);
        this.currentNode = null;
        Node<T> current = head;
        for(int i = 1; i < size; i++){
            current.setNextNode(new Node<T>(null));
            current = current.getNextNode();
        }
    }

    @Override
    public void add(T value) {
        Node<T> current = this.head;
        while(current != null && current.getValue() != null){
            current = current.getNextNode();
        }
        if(current != null){
            current.setValue(value);
        }
    }

    @Override
    public boolean contains(T value) {
        Node<T> current = this.head;
        while(current != null && 
              (
                current.getValue() == null || 
                !current.getValue().equals(value)
              )
            ){
            current = current.getNextNode();
        }
        return (current != null);
    }

    @Override
    public void remove(T value) throws NoSuchElementException {
        Node<T> current = this.head;
        while(current != null && 
              (
                current.getValue() == null || 
                !current.getValue().equals(value)
              )
            ){
            current = current.getNextNode();
        }
        if(current == null)
            throw new NoSuchElementException();
        current.setValue(null);
    }

    @Override
    public T getNext() {
        if(this.currentNode == null)
            this.currentNode = this.head;
        int i = 0;
        while(this.currentNode.getValue() == null && i < 2){
            this.currentNode = this.currentNode.getNextNode();
            if(this.currentNode == null){
                this.currentNode = this.head;
                i++;
            }
        }

        if(i >= 2){
            return null;
        }

        T value = (T) currentNode.getValue();
        this.currentNode = this.currentNode.getNextNode();
        while(this.currentNode != null && this.currentNode.getValue() == null)
            this.currentNode = this.currentNode.getNextNode();
        return value;
    }

    @Override
    public void reverseLinkedList() {
        Node<T> prev, next, current;
        prev = null;
        current = this.head;
        while(current != null){
            next = current.getNextNode();
            current.setNextNode(prev);
            prev = current;
            current = next;
        }
        this.head = prev;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public T getAt(int index) throws IndexOutOfBoundsException {
        int i = 0;
        Node<T> current = this.head;
        while(i < index){
            current = current.getNextNode();
            if(current == null){
                throw new IndexOutOfBoundsException(index);
            }
            i++;
        }
        return (T) current.getValue();
    }

    @Override
    public Node<T> getHead() {
        return this.head;
    }

    public boolean isFull() {
        boolean isFull = true;
        int i = 0;
        Node<T> current = this.head; 

        while(isFull && i < this.size){
            if(current.getValue() == null)
                isFull = false;
            current = current.getNextNode();
            i++;
        }
        return isFull;
    }
    
}
