package com.mycompany.app.linkedlist;

import java.util.NoSuchElementException;

public class LinkedList<T> implements LinkedListInterface<T> {
    private Node<T> head;

    private Node<T> currentNode;

    private int size;

    public LinkedList() {
        this.head = null;
        this.currentNode = null;
        this.size = 0;
    }

    public void add(T value) {
        if(this.head == null){
            this.head = new Node<T>(value);
        }
        else {
            Node<T> previous = null;
            Node<T> current = this.head;
            while(current != null) {
                previous = current;
                current = current.getNextNode();
            }
            previous.setNextNode(new Node<T>(value));
        }
        this.size++;
    }

    public boolean contains(T value){
        if(this.head == null)
            return false;
        Node<T> current = this.head;
        while(current != null && !current.getValue().equals(value)){
            current = current.getNextNode();
        }
        return current != null && current.getValue().equals(value);
    }

    public void remove(T value) throws NoSuchElementException {
        if(this.head != null){
            Node<T> previous = null;
            Node<T> current = this.head;
            while(current != null && !current.getValue().equals(value)) {
                previous = current;
                current = current.getNextNode();
            }
            if(current != null) {
                if(this.head == current){
                    this.head = current.getNextNode();
                }
                else{
                    previous.setNextNode(current.getNextNode());
                }
                if(this.currentNode == current) {
                    this.currentNode = current.getNextNode();
                }
                this.size--;
            }
            else{
                throw new NoSuchElementException();
            }
        }
    }

    public T getNext() {
        if(this.head == null)
            return null;
        if(this.currentNode == null)
            this.currentNode = this.head;
              
        T value = (T) currentNode.getValue();
        this.currentNode = this.currentNode.getNextNode();
        return value;
    }

    public void reverseLinkedList() {
        Node<T> prev;
        Node<T> next;
        Node<T> current;
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

    public int size(){
        return this.size;
    }

    public T getAt(int index) throws IndexOutOfBoundsException{
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

    public Node<T> getHead() {
        return head;
    }
}
