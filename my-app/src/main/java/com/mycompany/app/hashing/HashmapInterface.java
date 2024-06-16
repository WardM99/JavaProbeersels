package com.mycompany.app.hashing;

import java.util.NoSuchElementException;

public interface HashmapInterface<K, V> {
    void put(K key, V value);

    V get(K key) throws NoSuchElementException;

    V getOrDefault(K key, V defaultValue);

    void remove(K key) throws NoSuchElementException;

    void remove(K key, V value) throws NoSuchElementException;
    
    boolean containsKey(K key);
}
