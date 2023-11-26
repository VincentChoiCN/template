package coder.alex.tree;

/**
 *
 * https://leetcode.cn/problems/implement-trie-prefix-tree/description/
 */
class Trie {

  class Node {
    Node[] son = new Node[26];
    int count = 0; // 单词的个数

    public Node() {

    }
  }

  Node root;
  int count = 0;

  public Trie() {
    root = new Node();
  }

  public Node search(String word, int index, Node root) {
    if (index == word.length()) {
      return root;
    }
    Node son = root.son[word.charAt(index) - 'a'];
    if (son == null) {
      return null;
    }
    return search(word, index + 1, son);
  }

  public Node insert(String word, int index, Node root) {
    if (index == word.length()) {
      return root;
    }
    Node son = root.son[word.charAt(index) - 'a'];
    if (son == null) {
      son = root.son[word.charAt(index) - 'a'] = new Node();
    }
    return insert(word, index + 1, son);
  }


  public void insert(String word) {
    Node node = insert(word, 0, root);
    node.count++;
  }

  public boolean search(String word) {
    Node node = search(word, 0, root);
    return (node != null && node.count > 0) ? true : false;
  }

  public boolean startsWith(String prefix) {
    Node node = search(prefix, 0, root);
    return node == null ? false : true;
  }
}
