package com.mycompany.app.linkedlist;

import java.util.NoSuchElementException;

public interface LinkedListInterface<T> {
    public void add(T value);

    public boolean contains(T value);

    public void remove(T value) throws NoSuchElementException;
    
    public T getNext();

    public void reverseLinkedList();

    public int size();

    public T getAt(int index) throws IndexOutOfBoundsException;
    
    public Node<T> getHead();
}
