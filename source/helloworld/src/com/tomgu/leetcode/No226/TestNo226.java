package com.tomgu.leetcode.No226;

public class TestNo226 {

  public static void main(String[] args) {
    TreeNode n4 = new TreeNode(4);
    TreeNode n2 = new TreeNode(2);
    TreeNode n7 = new TreeNode(7);
    TreeNode n1 = new TreeNode(1);
    TreeNode n3 = new TreeNode(3);
    TreeNode n6 = new TreeNode(6);
    TreeNode n9 = new TreeNode(9);

    n4.left = n2;
    n4.right = n7;
    n2.left = n1;
    n2.right = n3;
    n7.left = n6;
    n7.right = n9;
    Solution226 s = new Solution226();
    System.out.println(s.invertTree(n4));
  }
}
