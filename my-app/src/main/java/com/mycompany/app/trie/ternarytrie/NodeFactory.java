package com.mycompany.app.trie.ternarytrie;

import com.mycompany.app.trie.NodeFactoryInterface;
import com.mycompany.app.trie.NodeInterface;

public class NodeFactory implements NodeFactoryInterface {

    @Override
    public NodeInterface newLeaf(String word) {
        return new TernaryTrieNode(word);
    }

    @Override
    public NodeInterface newNode() {
        return new TernaryTrieNode();
    }
    
}
