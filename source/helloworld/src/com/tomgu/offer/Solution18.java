package com.tomgu.offer;

/**
 * Created by guzuxing on 2018/10/14.
 */
public class Solution18 {

  public boolean HasSubtree(TreeNode root1, TreeNode root2) {
    if (root1 != null && root2 == null) {
      return false;
    }
    if (root1 == null && root2 == null) {
      return false;
    }
    if (root1 == null && root2 != null) {
      return false;
    }

    if (root1.val == root2.val) {
      if (checkSame(root1.left, root2.left) &&
          checkSame(root1.right, root2.right)) {
        return true;
      }
    }

    return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
  }

  public boolean checkSame(TreeNode root1, TreeNode root2) {
    if (root1 != null && root2 == null) {
      return true;
    }
    if (root1 == null && root2 == null) {
      return true;
    }
    if (root1 == null && root2 != null) {
      return false;
    }
    if (root1.val == root2.val) {
      return checkSame(root1.left, root2.left) && checkSame(root1.right, root2.right);
    } else {
      return false;
    }
  }
}
