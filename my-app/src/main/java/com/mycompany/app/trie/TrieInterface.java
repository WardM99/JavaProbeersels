package com.mycompany.app.trie;

public interface TrieInterface {
  void insert(String word);

  boolean search(String word);

  boolean startsWith(String prefix);
}
