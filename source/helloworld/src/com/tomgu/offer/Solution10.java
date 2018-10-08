package com.tomgu.offer;

public class Solution10 {
  public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
    if (pre.length == 0) {
      return null;
    }
    TreeNode root = buildTree(pre, 0, pre.length-1, in, 0, pre.length-1);

    return root;
  }

  private TreeNode buildTree(int[] pre, int p_s, int p_e, int[] in, int i_s, int i_e) {
    if (p_s == p_e) {
      return new TreeNode(pre[p_s]);
    }

    if (p_s > p_e) {
      return null;
    }

    if (i_s > i_e) {
      return null;
    }

    int flag = i_s;
    int delta = 0;
    for (; flag <= i_e; flag++) {
      if (pre[p_s] == in[flag]) {
        break;
      } else {
        delta++;
      }
    }

    TreeNode root = new TreeNode(pre[p_s]);
    root.left = buildTree(pre, p_s+1, p_s+delta, in, i_s, i_s+delta-1);
    root.right = buildTree(pre, p_s+delta+1, p_e, in, flag+1,i_e);
    return root;
  }

  public static void main(String[] args) {
    int[] pre = {1,2,4,7,3,5,6,8};
    int[] in = {4,7,2,1,5,3,8,6};
    TreeNode root = new Solution10().reConstructBinaryTree(pre, in);
    System.out.println(root);
  }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}



/**
 * Pre:{1,2,4,7,3,5,6,8}  in{4,7,2,1,5,3,8,6}
 *              1
 *         2         3
 *     4          5     6
 *       7            8
 *
 *
 */