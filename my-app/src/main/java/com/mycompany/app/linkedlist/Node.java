package com.mycompany.app.linkedlist;

public class Node<T> {
    private T value;
    private Node<T> nextNode;

    Node(T value) {
        this.value = value;
        this.nextNode = null;
    }

    public Node<T> getNextNode() {
        return nextNode;
    }

    public T getValue() {
        return value;
    }

    public void setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode;
    }
}
