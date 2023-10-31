package com.mycompany.app.trie.hashmaptrie;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.mycompany.app.trie.TrieInterface;
import org.junit.Before;
import org.junit.Test;

public class HashMapTrieTest {
  private TrieInterface trie;

  @Before
  public void setUp() {
    trie = new HashMapTrie();
  }

  @Test
  public void testInsert() {
    trie.insert("apple");
    assertTrue(trie.search("apple"));
  }

  @Test
  public void testSearch() {
    trie.insert("banana");
    assertTrue(trie.search("banana"));
    assertFalse(trie.search("apple"));
  }

  @Test
  public void testStartsWith() {
    trie.insert("apple");
    trie.insert("app");
    assertTrue(trie.startsWith("app"));
    assertFalse(trie.startsWith("ban"));
  }

  @Test
  public void testEmptyTrie() {
    assertFalse(trie.search("hello"));
    assertFalse(trie.startsWith("world"));
  }

  @Test
  public void testInsertEmptyString() {
    trie.insert("");
    assertTrue(trie.search(""));
    assertTrue(trie.startsWith(""));
  }

  @Test
  public void testMultipleInserts() {
    trie.insert("apple");
    trie.insert("app");
    trie.insert("banana");
    assertTrue(trie.search("apple"));
    assertTrue(trie.search("app"));
    assertTrue(trie.startsWith("app"));
    assertTrue(trie.startsWith("ban"));
    assertFalse(trie.search("orange"));
  }

  @Test
  public void testComplexScenarios() {
    trie.insert("app");
    trie.insert("apple");
    trie.insert("banana");
    assertTrue(trie.startsWith("a"));
    assertFalse(trie.search("apples"));
    assertFalse(trie.startsWith("or"));
    assertTrue(trie.search("banana"));
  }
}
