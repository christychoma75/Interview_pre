package com.tomgu.leetcode.No226;

public class Solution226 {

  public TreeNode invertTree(TreeNode root) {
    if (root == null) {
      return null;
    } else {
      TreeNode nleft = invertTree(root.left);
      TreeNode nright = invertTree(root.right);
      root.left = nright;
      root.right = nleft;
    }

    return root;
  }
}
