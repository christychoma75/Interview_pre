package com.tomgu.offer;

/**
 * Created by guzuxing on 2018/10/10.
 */

/**
 * public class TreeNode {
 * int val = 0;
 * TreeNode left = null;
 * TreeNode right = null;
 *
 * public TreeNode(int val) {
 * this.val = val;
 *
 * }
 *
 * }
 */
public class Solution17 {

  public void Mirror(TreeNode root) {
    if (root == null) {
      return;
    }
    if (root.left == null && root.right == null) {
      return;
    }
    Mirror(root.left);
    Mirror(root.right);
    TreeNode tem = root.left;
    root.left = root.right;
    root.right = tem;
  }
}
