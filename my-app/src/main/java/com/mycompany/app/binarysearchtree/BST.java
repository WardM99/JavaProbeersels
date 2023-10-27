package com.mycompany.app.binarysearchtree;

import java.util.NoSuchElementException;

public class BST<T> implements BSTInterface<T>{
    private BSTNodeInterface<T> root;

    public BST(){
        this.root = null;
    }

    @Override
    public void add(Comparable<T> value) throws IllegalArgumentException {
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
        boolean stop = false;
        T valueUnpacked = (T) value;
        if(this.root == null){
            return false;
        } 
        else {
            BSTNodeInterface<T> current = this.root;
            while(current != null && !stop){
                Comparable<T> currentValue = current.getValue();
                if(currentValue.compareTo(valueUnpacked) < 0){ //left child
                    current = current.getLeftChild();
                }
                else if(currentValue.compareTo(valueUnpacked) > 0){ //right child
                    current = current.getRightChild();
                }
                else { // same value
                    stop = true;
                }
            }
        }
        return stop;
    }

    private BSTNodeInterface<T> findNodeToRemove(T valueUnpacked,
                                                 boolean returnPrev){
        BSTNodeInterface<T> nodeToRemove = this.root;
        BSTNodeInterface<T> prev = null;
        boolean stop = false;
        while(nodeToRemove != null && !stop){
            Comparable<T> currentValue = nodeToRemove.getValue();
            if(currentValue.compareTo(valueUnpacked) < 0){ //left child
                prev = nodeToRemove;
                nodeToRemove = nodeToRemove.getLeftChild();
            }
            else if(currentValue.compareTo(valueUnpacked) > 0){ //right child
                prev = nodeToRemove;
                nodeToRemove = nodeToRemove.getRightChild();
            }
            else { // same value
                stop = true;
            }
        }

        if(nodeToRemove == null) {
            throw new NoSuchElementException();
        }
        
        return (returnPrev) ? prev : nodeToRemove;
    }

    @Override
    public void remove(Comparable<T> value) throws NoSuchElementException {
        // find node to remove
        T valueUnpacked = (T) value;
        BSTNodeInterface<T> nodeToRemove = findNodeToRemove(valueUnpacked,
                                                            false);
        BSTNodeInterface<T> prev = findNodeToRemove(valueUnpacked,true);


        // find largest node left or smallest node right

        BSTNodeInterface<T> newNode = null;
        BSTNodeInterface<T> prevNode = null;

        if(nodeToRemove.getLeftChild() != null){
            newNode = nodeToRemove.getLeftChild();
            while(newNode.getRightChild() != null){
                prevNode = newNode;
                newNode = newNode.getRightChild();
            }
        }
        else if(nodeToRemove.getRightChild() != null){
            newNode = nodeToRemove.getRightChild();
            while(newNode.getLeftChild() != null){
                prevNode = newNode;
                newNode = newNode.getLeftChild();
            }
        }
        // node can just be removed
        if(prev == null){
            this.root = newNode;
        }
        else{
            Comparable<T> prevValue = prev.getValue();
            if(prevValue.compareTo(valueUnpacked) < 0){
                prev.setLeftChild(newNode);
            }
            else {
                prev.setRightChild(newNode);
            }
        }
        // fix children
        fixChildren(prevNode, newNode, nodeToRemove);
    }

    private void fixChildren(BSTNodeInterface<T> prevNode,
                             BSTNodeInterface<T> newNode,
                             BSTNodeInterface<T> nodeToRemove){
        if(prevNode != null){
            if(newNode != null && prevNode.getRightChild().getValue().equals(newNode.getValue())){
                prevNode.setRightChild(newNode.getLeftChild());
            }
            else if(newNode != null && prevNode.getLeftChild().getValue().equals(newNode.getValue())){
                prevNode.setLeftChild(newNode.getRightChild());
            }
        }

        if(newNode != null){
            newNode.setLeftChild(nodeToRemove.getLeftChild());
            newNode.setRightChild(nodeToRemove.getRightChild());
        }
    }
    
}
