package com.mycompany.app.trie;

public interface NodeFactoryInterface {
    public NodeInterface newLeaf(String word);

    public NodeInterface newNode();
}
