package com.tomgu.leetcode.No538;

public class TestNo538 {

  public static void main(String[] args) {
    TreeNode a5 = new TreeNode(5);
    TreeNode a2 = new TreeNode(2);
    TreeNode a13 = new TreeNode(13);
    TreeNode a1 = new TreeNode(1);
    TreeNode a7 = new TreeNode(7);
    TreeNode a9 = new TreeNode(9);
    TreeNode a16 = new TreeNode(16);
    a5.left = a2;
    a5.right = a13;
    a2.left = a1;
    a13.left = a7;
    a13.right = a16;
    a7.right = a9;

    Solution538 s = new Solution538();
    s.convertBST(a5);
    System.out.println(a5);
  }
}
