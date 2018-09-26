package com.tomgu.leetcode.No104;

public class Solution104 {

  public int maxDepth(TreeNode root) {
    int result = 0;
    if (root == null) {
      result = 0;
    } else if ((root.left == null) && (root.right == null)) {
      result = 1;
    } else if (root.left == null && root.right != null) {
      result = maxDepth(root.right) + 1;
    } else if (root.left != null && root.right == null) {
      result = maxDepth(root.left) + 1;
    } else {
      result = Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    return result;
  }
}
