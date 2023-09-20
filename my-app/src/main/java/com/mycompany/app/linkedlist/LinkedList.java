package com.mycompany.app.linkedlist;

public class LinkedList<T> {
    private Node<T> head;

    LinkedList() {
        this.head = null;
    }

    public void add(Comparable<T> value) {
        if(this.head == null){
            this.head = new Node<T>(value);
        }
        Node<T> previous = null;
        Node<T> current = this.head;
        while(current != null) {
            previous = current;
            current = current.getNextNode();
        }
        previous.setNextNode(new Node<T>(value));
    }

    public boolean contains(Comparable<T> value){
        if(this.head == null)
            return false;
        Node<T> current = this.head;
        while(current != null && !current.getValue().equals(value)){
            current = current.getNextNode();
        }
        return current != null;
    }
}
