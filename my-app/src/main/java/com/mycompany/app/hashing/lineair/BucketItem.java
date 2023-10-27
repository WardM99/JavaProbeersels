package com.mycompany.app.hashing.lineair;

public class BucketItem<K,V> {
    private K key;

    private V value;

    public BucketItem(K key, V value){
        this.key = key;
        this.value = value;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public K getKey() {
        return key;
    }
    
    public V getValue() {
        return value;
    }

    @SuppressWarnings (value="unchecked")
    @Override
    public boolean equals(Object o){
        if(o == this)
            return true;
        if (!(o instanceof BucketItem)) {
            return false;
        }
        
        BucketItem<K,V> c = (BucketItem<K,V>) o;

        return this.key.equals(c.getKey());
    }
}
