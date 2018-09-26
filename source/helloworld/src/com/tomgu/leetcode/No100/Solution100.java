package com.tomgu.leetcode.No100;

public class Solution100 {

  public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) {
      return true;
    }

    if (p == null && q != null) {
      return false;
    }

    if (p != null && q == null) {
      return false;
    }

    if (p.val != q.val) {
      return false;
    }

    if (!isSameTree(p.left, q.left)) {
      return false;
    }

    return isSameTree(p.right, q.right);
  }
}
