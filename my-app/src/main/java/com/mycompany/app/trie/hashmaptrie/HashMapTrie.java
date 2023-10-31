package com.mycompany.app.trie.hashmaptrie;

import com.mycompany.app.trie.TrieInterface;

public class HashMapTrie implements TrieInterface {
  private Node head;

  public HashMapTrie() { this.head = new Node(false, null); }

  @Override
  public void insert(String word) {
    String newWord = word + '\u0000';
    Node newLeaf = new Node(true, newWord);

    int i = 0;
    char currentChar = '\u0000';
    Node prevPrevNode = null;
    Node prevNode = null;
    Node currentNode = this.head;

    while (currentNode != null) {
      currentChar = newWord.charAt(i);
      prevPrevNode = prevNode;
      prevNode = currentNode;
      currentNode = currentNode.getNextNode(currentChar);
      i++;
    }

    if (!prevNode.isLeaf()) {
      prevNode.addNextNode(currentChar, newLeaf);
    } else {
      i -= 2;
      char charNewWord = newWord.charAt(i);
      char charOldWord = prevNode.getWord().charAt(i);
      while (charNewWord == charOldWord) {
        Node newNode = new Node(false, null);
        prevPrevNode.addNextNode(charOldWord, newNode);
        prevPrevNode = newNode;
        i++;

        charNewWord = newWord.charAt(i);
        charOldWord = prevNode.getWord().charAt(i);
      }
      System.out.println((int) charNewWord);
      System.out.println((int) charOldWord);
      prevPrevNode.addNextNode(charOldWord, prevNode);
      prevPrevNode.addNextNode(charNewWord, newLeaf);
    }
  }

  @Override
  public boolean search(String word) {
    String searchWord = word + '\u0000';
    int i = 0;
    char currentChar = '\u0000';
    Node currentNode = this.head;

    boolean stop = false;

    while (!stop && currentNode != null) {
      if (currentNode.isLeaf()) {
        stop = true;
      } else {
        currentChar = searchWord.charAt(i);
        currentNode = currentNode.getNextNode(currentChar);
        i++;
      }
    }

    if (!stop) return false;

    return currentNode != null && currentNode.getWord().equals(searchWord);
  }

  @Override
  public boolean startsWith(String prefix) {
    String searchWord = prefix + '\u0000';
    int i = 0;
    char currentChar = searchWord.charAt(i);
    Node currentNode = this.head;

    while (currentNode != null && !currentNode.isLeaf() && currentChar != '\u0000') {
      currentNode = currentNode.getNextNode(currentChar);
      i++;
      currentChar = searchWord.charAt(i);
    }
    return currentNode != null;
  }
}
