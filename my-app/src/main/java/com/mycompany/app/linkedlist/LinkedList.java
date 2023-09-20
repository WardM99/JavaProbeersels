package com.mycompany.app.linkedlist;

public class LinkedList<T> implements LinkedListInterface<T> {
    private Node<T> head;

    LinkedList() {
        this.head = null;
    }

    public void add(Comparable<T> value) {
        if(this.head == null){
            this.head = new Node<T>(value);
        }
        else {
            Node<T> previous = null;
            Node<T> current = this.head;
            while(current != null) {
                previous = current;
                current = current.getNextNode();
            }
            previous.setNextNode(new Node<T>(value));
        }
    }

    public boolean contains(Comparable<T> value){
        if(this.head == null)
            return false;
        Node<T> current = this.head;
        while(current != null && !current.getValue().equals(value)){
            current = current.getNextNode();
        }
        return current != null && current.getValue().equals(value);
    }

    public void remove(Comparable<T> value) {
        if(this.head != null){
            Node<T> previous = null;
            Node<T> current = this.head;
            while(current != null && !current.getValue().equals(value)) {
                previous = current;
                current = current.getNextNode();
            }
            if(this.head == current){
                this.head = current.getNextNode();
            }
            else{
                previous.setNextNode(current.getNextNode());
            }
        }
    }
}
