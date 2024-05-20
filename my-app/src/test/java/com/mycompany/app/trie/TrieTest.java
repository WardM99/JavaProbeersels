package com.mycompany.app.trie;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public abstract class TrieTest {
  private TrieInterface trie;

  public void setTrie(TrieInterface trie){
    this.trie = trie;
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
