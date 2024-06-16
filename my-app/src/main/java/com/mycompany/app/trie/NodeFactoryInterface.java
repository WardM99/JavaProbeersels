package com.mycompany.app.trie;

public interface NodeFactoryInterface {
    NodeInterface newLeaf(String word);

    NodeInterface newNode();
}
