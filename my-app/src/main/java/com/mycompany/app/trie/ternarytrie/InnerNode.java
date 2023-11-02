package com.mycompany.app.trie.ternarytrie;

import com.mycompany.app.trie.NodeInterface;

public class InnerNode {
    private char character;

    private NodeInterface node;

    private InnerNode leftChild;

    private InnerNode rightChild;

    public InnerNode(char character, NodeInterface node) {
        this.character = character;
        this.node = node;
        this.leftChild = null;
        this.rightChild = null;
    }

    public void addInnerNode(char character, NodeInterface node){
        if(character == this.character)
            this.node = node;
        else
            makeNewNode(character, node);
    }

    private void makeNewNode(char character, NodeInterface node) {
        InnerNode newNode = new InnerNode(character, node);
        InnerNode currentNode = this;
        boolean stop = false;
        while (!stop) {
            if(character < currentNode.character){
                if(currentNode.leftChild != null)
                    currentNode = currentNode.leftChild;
                else{
                    stop = true;
                    currentNode.leftChild = newNode;
                }
            }
            else if(character > currentNode.character){
                if(currentNode.rightChild != null)
                    currentNode = currentNode.rightChild;
                else{
                    stop = true;
                    currentNode.rightChild = newNode;
                }
            }
        }
    }

    public NodeInterface getNextNode(char character){
        InnerNode current = this;
        boolean stop = false;

        while (!stop) {
            if(current == null || current.character == character){
                stop = true;
            }
            else{
                if(character < current.character)
                    current = current.leftChild;
                else if(character > current.character)
                    current = current.rightChild;
            }
        }

        return (current == null) ? null : current.node;
    }
}
