package com.mycompany.app.trie.ternarytrie;

import com.mycompany.app.trie.NodeInterface;

public class TernaryTrieNode implements NodeInterface {
    private boolean leaf;

    private String word;

    private InnerNode head;

    public TernaryTrieNode(){
        this.leaf = false;
        this.word = null;
        this.head = null;
    }

    public TernaryTrieNode(String word) {
        this.leaf = true;
        this.word = word;
        this.head = null;
    }

    @Override
    public NodeInterface getNextNode(Character c) {
        if(this.head == null)
            return null;
        return this.head.getNextNode(c);
    }

    @Override
    public void addNextNode(char c, NodeInterface n) {
        if(this.head == null)
            this.head = new InnerNode(c, n);
        else
            this.head.addInnerNode(c, n);
    }

    @Override
    public boolean isLeaf() {
        return this.leaf;
    }

    @Override
    public String getWord() {
        return this.word;
    }

}
