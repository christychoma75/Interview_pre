package com.tomgu.leetcode.No617;

public class Solution617 {

  public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    if (t1 == null && t2 == null) {
      return null;
    }
    if (t1 != null && t2 == null) {
      return deepCopy(t1);
    }

    if (t1 == null && t2 != null) {
      return deepCopy(t2);
    }

    TreeNode newRoot = new TreeNode(t1.val + t2.val);
    addLeft(newRoot, t1.left, t2.left);
    addRight(newRoot, t1.right, t2.right);
    return newRoot;
  }

  private void addLeft(TreeNode newRoot, TreeNode l1, TreeNode l2) {
    if (l1 == null && l2 == null) {
      newRoot.left = null;
      return;
    }

    if (l1 != null && l2 == null) {
      newRoot.left = deepCopy(l1);
      return;
    }

    if (l1 == null && l2 != null) {
      newRoot.left = deepCopy(l2);
      return;
    }

    if (l1 != null && l2 != null) {
      TreeNode newLeft = new TreeNode(l1.val + l2.val);
      newRoot.left = newLeft;
      addLeft(newLeft, l1.left, l2.left);
      addRight(newLeft, l1.right, l2.right);
      return;
    }
  }

  private void addRight(TreeNode newRoot, TreeNode r1, TreeNode r2) {
    if (r1 == null && r2 == null) {
      newRoot.right = null;
      return;
    }

    if (r1 != null && r2 == null) {
      newRoot.right = deepCopy(r1);
      return;
    }

    if (r1 == null && r2 != null) {
      newRoot.right = deepCopy(r2);
      return;
    }

    if (r1 != null && r2 != null) {
      TreeNode newRight = new TreeNode(r1.val + r2.val);
      newRoot.right = newRight;
      addLeft(newRight, r1.left, r2.left);
      addRight(newRight, r1.right, r2.right);
      return;
    }
  }

  public TreeNode deepCopy(TreeNode root) {
    if (root == null) {
      return null;
    }
    TreeNode newRoot = new TreeNode(root.val);
    newRoot.left = deepCopy(root.left);
    newRoot.right = deepCopy(root.right);

    return newRoot;
  }
}
