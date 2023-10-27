package com.mycompany.app.hashing.lineair;

import java.util.NoSuchElementException;

import com.mycompany.app.linkedlist.fixedsize.LinkedListFixedSize;

public class Bucket<K, V> {
    private int size;

    private Bucket<K,V> overflowBucket;

    private LinkedListFixedSize<BucketItem<K,V>> items;

    public Bucket(int size){
        this.size = size;
        this.items = new LinkedListFixedSize<BucketItem<K,V>>(size);
        this.overflowBucket = null;
    }

    public void add(K key, V value){
        BucketItem<K,V> newItem = new BucketItem<K,V>(key, value);
        if(this.items.isFull()){
            if(this.overflowBucket == null)
                this.overflowBucket = new Bucket<>(this.size);
            this.overflowBucket.add(key, value);
        }
        else{
            this.items.add(newItem);
        }
    }

    public boolean contains(K key) {
        BucketItem<K,V> searchItem = new BucketItem<K,V>(key, null);
        boolean inHere = this.items.contains(searchItem);
        if(!inHere){
            if(this.overflowBucket == null)
                return false;
            return this.overflowBucket.contains(key);
        }
        return true;
    }

    public void remove(K key) throws NoSuchElementException {
        BucketItem<K,V> deleteItem = new BucketItem<K,V>(key, null);
        try{
            this.items.remove(deleteItem);
        }
        catch(NoSuchElementException e){
            if(this.overflowBucket == null)
                throw new NoSuchElementException();
            this.overflowBucket.remove(key);
        }
    }

    public void remove(K key, V value) throws NoSuchElementException {
        V itemValue = get(key);
        if(!itemValue.equals(value))
            throw new NoSuchElementException();
        remove(key);
    }

    public V get(K key) throws NoSuchElementException {
        boolean found = false;
        int i = 0;
        BucketItem<K,V> item = null;
        while(!found && i < this.size){
            item = this.items.getAt(i);
            if(item != null && item.getKey() == key){
                found = true;
            }
            else{
                i++;
            }
        }
        if(!found){
            if(this.overflowBucket == null)
                throw new NoSuchElementException();
            else
                return this.overflowBucket.get(key);
        }
        return item.getValue();
    }

    public Bucket<K, V> getOverflowBucket() {
        return overflowBucket;
    }
    
    public LinkedListFixedSize<BucketItem<K, V>> getItems() {
        return items;
    }
}
