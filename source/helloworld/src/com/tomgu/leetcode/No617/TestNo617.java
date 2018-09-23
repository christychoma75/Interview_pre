package com.tomgu.leetcode.No617;

public class TestNo617 {

  public static void main(String[] args) {
    TreeNode a1 = new TreeNode(1);
    TreeNode a3 = new TreeNode(3);
    TreeNode a2 = new TreeNode(2);
    TreeNode a5 = new TreeNode(5);
    a1.left = a3;
    a1.right = a2;
    a3.left = a5;

    TreeNode b1 = new TreeNode(1);
    TreeNode b3 = new TreeNode(3);
    TreeNode b2 = new TreeNode(2);
    TreeNode b4 = new TreeNode(4);
    TreeNode b7 = new TreeNode(7);
    b2.left = b1;
    b2.right = b3;
    b1.right = b4;
    b3.right = b7;

    Solution617 solution = new Solution617();
    TreeNode newRootA = solution.deepCopy(a1);
    TreeNode newRootB = solution.deepCopy(b2);

    TreeNode newRoot = solution.mergeTrees(a1, b2);
    System.out.println(newRoot.val);
  }
}
