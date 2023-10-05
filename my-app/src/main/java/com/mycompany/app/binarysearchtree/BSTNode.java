package com.mycompany.app.binarysearchtree;

public class BSTNode<T> implements BSTNodeInterface<T> {
    private BSTNodeInterface<T> leftNode;
    private BSTNodeInterface<T> rightNode;
    private Comparable<T> value;

    BSTNode(Comparable<T> value){
        this.value = value;
        this.leftNode = null;
        this.rightNode = null;
    }

    @Override
    public Comparable<T> getValue() {
        return this.value;
    }

    @Override
    public void setLeftChild(BSTNodeInterface<T> leftChild) {
        this.leftNode = leftChild;
    }

    @Override
    public void setRightChild(BSTNodeInterface<T> rightChild) {
        this.rightNode = rightChild;
    }

    @Override
    public BSTNodeInterface<T> getLeftChild() {
        return this.leftNode;
    }

    @Override
    public BSTNodeInterface<T> getRightChild() {
        return this.rightNode;
    }    
}
