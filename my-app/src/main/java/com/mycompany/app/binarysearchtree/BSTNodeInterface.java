package com.mycompany.app.binarysearchtree;

public interface BSTNodeInterface<T> {
    Comparable<T> getValue();

    void setLeftChild(BSTNodeInterface<T> leftChild);

    void setRightChild(BSTNodeInterface<T> rightChild);

    BSTNodeInterface<T> getLeftChild();
    
    BSTNodeInterface<T> getRightChild();
}
