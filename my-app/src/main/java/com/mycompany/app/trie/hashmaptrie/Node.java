package com.mycompany.app.trie.hashmaptrie;

import com.mycompany.app.hashing.lineair.LineairHashMap;

public class Node {
    private LineairHashMap<Character, Node> map;

    private String word;

    private boolean leaf;

    public Node(boolean leaf, String word){
        this.leaf = leaf;
        this.word = word;
        this.map = new LineairHashMap<Character, Node>();
    }

    public Node getNextNode(Character c){
        return map.getOrDefault(c, null);
    }

    public void addNextNode(char c, Node n){
        map.put(c, n);
    }

    public boolean isLeaf(){
        return leaf;
    }

    public String getWord() {
        return word;
    }
}
