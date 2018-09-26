package com.tomgu.leetcode.No104;

public class TestNo104 {

  public static void main(String[] args) {
    TreeNode n3 = new TreeNode(3);
    TreeNode n9 = new TreeNode(9);
    TreeNode n20 = new TreeNode(20);
    TreeNode n15 = new TreeNode(15);
    TreeNode n7 = new TreeNode(7);
    n3.left = n9;
    n3.right = n20;
    n20.left = n15;
    n20.right = n7;
    Solution104 s = new Solution104();
    System.out.println(s.maxDepth(n3));
  }
}
