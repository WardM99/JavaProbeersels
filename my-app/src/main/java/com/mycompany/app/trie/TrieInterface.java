package com.mycompany.app.trie;

public interface TrieInterface {
    public void insert(String word);

    public boolean search(String word);

    public boolean startsWith(String prefix);
}
