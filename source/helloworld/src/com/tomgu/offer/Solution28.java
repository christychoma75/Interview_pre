package com.tomgu.offer;

public class Solution28 {

  int max = 0;

  public int TreeDepth(TreeNode root) {
    build(root, 0);
    return max;
  }

  private void build(TreeNode root, int curDepth) {
    if (root == null) {
      return;
    } else {
      curDepth++;
      if (curDepth > max) {
        max = curDepth;
      }
      build(root.left, curDepth);
      build(root.right, curDepth);
    }
  }

  public static void main(String[] arg) {
    TreeNode n10 = new TreeNode(10);
    TreeNode n5 = new TreeNode(5);
    TreeNode n4 = new TreeNode(4);
    TreeNode n7 = new TreeNode(7);
    TreeNode n12 = new TreeNode(12);
    n10.left = n12;
    n10.right = n5;
    n5.left = n4;
    n5.right = n7;
    System.out.println(new Solution28().TreeDepth(n10));
  }
}
