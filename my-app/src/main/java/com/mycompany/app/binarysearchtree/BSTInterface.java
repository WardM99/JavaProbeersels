package com.mycompany.app.binarysearchtree;

public interface BSTInterface<T> {
    public void add(Comparable<T> value);
    public boolean contains(Comparable<T> value);
    public void remove(Comparable<T> value); 
}
