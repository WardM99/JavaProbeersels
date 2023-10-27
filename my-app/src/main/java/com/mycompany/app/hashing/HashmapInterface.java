package com.mycompany.app.hashing;

import java.util.NoSuchElementException;

public interface HashmapInterface<K, V> {
    public void put(K key, V value);
    public V get(K key) throws NoSuchElementException;
    public V getOrDefault(K key, V defaultValue);
    public void remove(K key) throws NoSuchElementException;
    public void remove(K key, V value) throws NoSuchElementException;
    public boolean containsKey(K key);
}
