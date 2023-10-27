package com.mycompany.app.hashing.lineair;

import java.util.NoSuchElementException;

import com.mycompany.app.hashing.HashmapInterface;
import com.mycompany.app.linkedlist.fixedsize.LinkedListFixedSize;
import com.mycompany.app.linkedlist.LinkedList;

public class LineairHashMap<K, V> implements HashmapInterface<K, V> {

    private final double UPPERLOADFACTOR = 0.9;
    private final int BUCKETSIZE = 2;
    private LinkedList<Bucket<K,V>> buckets;
    private int n = 2;
    private int b = 1;
    private int a = 0;

    private int nextIndexRefactor = 0;

    public LineairHashMap(){
        this.buckets = new LinkedList<Bucket<K,V>>();
        for(int i = 0; i < this.n; i++){
            this.buckets.add(new Bucket<K,V>(BUCKETSIZE));
        }
    }

    @Override
    public void put(K key, V value) {
        
        Bucket<K,V> inserBucket = getBucket(key);
        inserBucket.add(key, value);
        this.a++;
        double loadfactor = (this.a)/(1.0*this.n*this.BUCKETSIZE);
        if(loadfactor >= UPPERLOADFACTOR)
            reorgenize();
    }

    private Bucket<K,V> getBucket(K key){
        int hash = key.hashCode();
        int mask = getMask();
        int indexValue = hash&mask;
        if(indexValue >= this.n){
            mask = mask >>1;
            indexValue = hash&(mask);
        }
        return this.buckets.getAt(indexValue);
    }

    private int getMask(){
        int mask = 0x00;
        for (int i = 0; i < this.b; i++) {
            mask = (mask<<1)|0x01;
        }
        return mask;
    }

    private void reorgenize(){
        // add new bucket
        Bucket<K,V> newBucket = new Bucket<K,V>(BUCKETSIZE);
        this.buckets.add(newBucket);
        this.n = this.buckets.size();
        
        if(this.n > Math.pow(2,this.b)){
            this.b++;
            this.nextIndexRefactor = 0;
        }
        int wrongIndex = this.nextIndexRefactor;

        Bucket<K,V> b = this.buckets.getAt(wrongIndex);
        while(b != null){
            LinkedListFixedSize<BucketItem<K,V>> items = b.getItems();
            for (int index = 0; index < BUCKETSIZE; index++) {
                BucketItem<K,V> item = items.getNext();
                if(item != null){
                    K key = item.getKey();
                    V value = item.getValue();
                    int hash = key.hashCode();
                    int mask = getMask();
                    int indexValue = hash&mask;
                    if(indexValue != wrongIndex){
                        b.remove(key);
                        newBucket.add(key, value);
                    }
                }
            }
            b = b.getOverflowBucket();
        }

        // append nextIndexRefactor
        this.nextIndexRefactor++;
    }

    @Override
    public V get(K key) throws NoSuchElementException {
        Bucket<K,V> searchBucket = getBucket(key);
        return searchBucket.get(key);
    }

    @Override
    public V getOrDefault(K key, V defaultValue) {
        try{
            Bucket<K,V> searchBucket = getBucket(key);
            return searchBucket.get(key);
        }
        catch(NoSuchElementException e){
            return defaultValue;
        }
    }

    @Override
    public void remove(K key) throws NoSuchElementException {
        Bucket<K,V> removeBucket = getBucket(key);
        removeBucket.remove(key);
    }

    @Override
    public void remove(K key, V value) throws NoSuchElementException {
        Bucket<K,V> removeBucket = getBucket(key);
        removeBucket.remove(key, value);
    }

    @Override
    public boolean containsKey(K key) {
        try{
            get(key);
            return true;
        }
        catch(NoSuchElementException e){
            return false;
        }
    }
    
}
