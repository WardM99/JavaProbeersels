package com.mycompany.app.trie.hashmaptrie;

import com.mycompany.app.trie.TrieTest;

import org.junit.jupiter.api.BeforeEach;

public class HashMapTrieTest extends TrieTest{

  @BeforeEach
  public void setUp() {
    setTrie(new HashMapTrie());
  }

}
