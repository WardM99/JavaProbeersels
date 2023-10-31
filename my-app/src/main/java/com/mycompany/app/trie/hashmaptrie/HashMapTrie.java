package com.mycompany.app.trie.hashmaptrie;

import com.mycompany.app.trie.Trie;

public class HashMapTrie extends Trie {

  public HashMapTrie() { 
    setFactory(new NodeFactory());
  }

}
