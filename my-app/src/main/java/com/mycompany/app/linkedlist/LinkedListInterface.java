package com.mycompany.app.linkedlist;

public interface LinkedListInterface<T> {
    public void add(Comparable<T> value);
    public boolean contains(Comparable<T> value);
    public void remove(Comparable<T> value);
    public void sort();
    public T getNext();
    public void reverseLinkedList();
    public int size();
    public T getAt(int index);
    public Node<T> getHead();
}
