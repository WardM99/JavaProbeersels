package com.mycompany.app.binarysearchtree;

import java.util.NoSuchElementException;

public interface BSTInterface<T> {
    public void add(Comparable<T> value) throws IllegalArgumentException;
    public boolean contains(Comparable<T> value);
    public void remove(Comparable<T> value) throws NoSuchElementException; 
}
