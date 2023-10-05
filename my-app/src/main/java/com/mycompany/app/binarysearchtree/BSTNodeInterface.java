package com.mycompany.app.binarysearchtree;

public interface BSTNodeInterface<T> {
    public Comparable<T> getValue();
    public void setLeftChild(BSTNodeInterface<T> leftChild);
    public void setRightChild(BSTNodeInterface<T> RightChild);
    public BSTNodeInterface<T> getLeftChild();
    public BSTNodeInterface<T> getRightChild();
}
