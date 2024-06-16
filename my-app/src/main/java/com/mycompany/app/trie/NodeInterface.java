package com.mycompany.app.trie;

public interface NodeInterface {
    NodeInterface getNextNode(Character c);

    void addNextNode(char c, NodeInterface n);

    boolean isLeaf();

    String getWord();
}
