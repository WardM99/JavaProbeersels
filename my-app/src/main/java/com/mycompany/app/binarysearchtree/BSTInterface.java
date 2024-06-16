package com.mycompany.app.binarysearchtree;

import java.util.NoSuchElementException;

public interface BSTInterface<T> {
    void add(Comparable<T> value) throws IllegalArgumentException;
    
    boolean contains(Comparable<T> value);

    void remove(Comparable<T> value) throws NoSuchElementException;
}
