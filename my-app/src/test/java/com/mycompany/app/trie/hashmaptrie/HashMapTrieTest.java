package com.mycompany.app.trie.hashmaptrie;

import com.mycompany.app.trie.TrieTest;

import org.junit.Before;

public class HashMapTrieTest extends TrieTest{

  @Before
  public void setUp() {
    setTrie(new HashMapTrie());
  }

}
