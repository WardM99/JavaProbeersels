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

    public void sort() {
        if(this.head != null){
            Node<T> pivot = this.head;
            T pivotValue = (T) pivot.getValue();
            Node<T> current = this.head.getNextNode();
            LinkedList<T> left = new LinkedList<T>();
            LinkedList<T> right = new LinkedList<T>();
            while(current != null){
                Comparable<T> currentValue = current.getValue();
                //System.out.println(currentValue);
                if(currentValue.compareTo(pivotValue) < 0)
                    left.add(current.getValue());
                else
                    right.add(current.getValue());
                current = current.getNextNode();
            }
            left.sort();
            right.sort();
            if(left.getHead() == null){
                this.head = pivot;
            }
            else{
                this.head = left.getHead();
                current = this.head;
                Node<T> previous = null;
                while(current != null){
                    previous = current;
                    current = current.getNextNode();
                }
                previous.setNextNode(pivot);
            }
            pivot.setNextNode(right.getHead());
        }
    }

    public T getNext() {
        return head.getValue();
    }

    public Node<T> getHead() {
        return head;
    }
}
