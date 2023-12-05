package coder.alex.map;

import java.util.Stack;

public class BinaryTree {

  class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;
  }

  Stack<TreeNode> stack = new Stack<>();

  public void inorderTraversalNonRecursion(TreeNode root) {
    if(root != null) {
      pushLeft(root);
    }

    while(!stack.isEmpty()) {
      TreeNode cur = stack.pop();
      if(cur.right != null) {
        pushLeft(cur.right);
      }
    }
  }

  public void pushLeft(TreeNode root) {
    while(root.left != null) {
      stack.push(root);
      root = root.left;
    }
    stack.push(root);
  }
}
