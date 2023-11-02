package com.mycompany.app.trie.ternarytrie;

import com.mycompany.app.trie.TrieTest;

import org.junit.jupiter.api.BeforeEach;

public class TernayTrieTest extends TrieTest {

  @BeforeEach
  public void setUp() {
    setTrie(new TernaryTrie());
  }
}
