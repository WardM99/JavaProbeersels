package com.mycompany.app.linkedlist;

import java.util.NoSuchElementException;

public interface LinkedListInterface<T> {
    public void add(Comparable<T> value);
    public boolean contains(Comparable<T> value);
    public void remove(Comparable<T> value) throws NoSuchElementException;
    public void sort();
    public T getNext();
    public void reverseLinkedList();
    public int size();
    public T getAt(int index) throws IndexOutOfBoundsException;
    public Node<T> getHead();
}
