package com.mycompany.app.trie;

public interface NodeInterface {
    public NodeInterface getNextNode(Character c);

    public void addNextNode(char c, NodeInterface n);

    public boolean isLeaf();

    public String getWord();
}
