package com.mycompany.app.trie.hashmaptrie;

import com.mycompany.app.trie.NodeFactoryInterface;
import com.mycompany.app.trie.NodeInterface;

public class NodeFactory implements NodeFactoryInterface {

    @Override
    public NodeInterface newLeaf(String word) {
        return new HashMapTrieNode(true, word);
    }

    @Override
    public NodeInterface newNode() {
        return new HashMapTrieNode(false, null);
    }
    
}
