package com.mycompany.app.trie.hashmaptrie;

import com.mycompany.app.hashing.lineair.LineairHashMap;
import com.mycompany.app.trie.NodeInterface;

public class HashMapTrieNode implements NodeInterface {
    private final LineairHashMap<Character, NodeInterface> map;

    private final String word;

    private final boolean leaf;

    public HashMapTrieNode(boolean leaf, String word){
        this.leaf = leaf;
        this.word = word;
        this.map = new LineairHashMap<Character, NodeInterface>();
    }

    @Override
    public NodeInterface getNextNode(Character c){
        return map.getOrDefault(c, null);
    }

    @Override
    public boolean isLeaf(){
        return leaf;
    }

    @Override
    public String getWord() {
        return word;
    }

    @Override
    public void addNextNode(char c, NodeInterface n) {
        this.map.put(c, n);
    }
}
