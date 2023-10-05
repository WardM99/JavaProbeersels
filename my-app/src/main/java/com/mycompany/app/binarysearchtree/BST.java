package com.mycompany.app.binarysearchtree;

public class BST<T> implements BSTInterface<T>{
    private BSTNodeInterface<T> root;

    BST(){
        this.root = null;
    }

    @Override
    public void add(Comparable<T> value) {
        T valueUnpacked = (T) value;
        if(this.root == null){
            this.root = new BSTNode<T>(value);
        } 
        else {
            BSTNodeInterface<T> current = this.root;
            BSTNodeInterface<T> prev = this.root;
            while(current != null){
                prev = current;
                Comparable<T> currentValue = current.getValue();
                if(currentValue.compareTo(valueUnpacked) < 0){ //left child
                    current = current.getLeftChild();
                }
                else if(currentValue.compareTo(valueUnpacked) > 0){ //right child
                    current = current.getRightChild();
                }
                else { // same value
                    throw new IllegalArgumentException("Value already in tree");
                }
            }
            Comparable<T> prevValue = prev.getValue();
            if(prevValue.compareTo(valueUnpacked) < 0){ //left child
                prev.setLeftChild(new BSTNode<T>(value));
            }
            else if(prevValue.compareTo(valueUnpacked) > 0){ //right child
                prev.setRightChild(new BSTNode<T>(value));
            }
        }
    }

    @Override
    public boolean contains(Comparable<T> value) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'contains'");
    }

    @Override
    public void remove(Comparable<T> value) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }
    
}
