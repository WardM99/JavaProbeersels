package com.mycompany.app.linkedlist;

public class Node<T> {
    private Comparable<T> value;
    private Node<T> nextNode;

    Node(Comparable<T> value) {
        this.value = value;
        this.nextNode = null;
    }

    public Node<T> getNextNode() {
        return nextNode;
    }

    public Comparable<T> getValue() {
        return value;
    }

    public void setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode;
    }
}
