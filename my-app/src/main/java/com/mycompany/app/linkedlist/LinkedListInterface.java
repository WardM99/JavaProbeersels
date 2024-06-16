package com.mycompany.app.linkedlist;

import java.util.NoSuchElementException;

public interface LinkedListInterface<T> {
    void add(T value);

    boolean contains(T value);

    void remove(T value) throws NoSuchElementException;
    
    T getNext();

    void reverseLinkedList();

    int size();

    T getAt(int index) throws IndexOutOfBoundsException;
    
    Node<T> getHead();
}
