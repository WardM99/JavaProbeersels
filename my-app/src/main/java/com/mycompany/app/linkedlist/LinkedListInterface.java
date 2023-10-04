package com.mycompany.app.linkedlist;

public interface LinkedListInterface<T> {
    public void add(Comparable<T> value);
    public boolean contains(Comparable<T> value);
    public void remove(Comparable<T> value);
    public void sort();
    public T getNext();
    public Node<T> getHead();
}
