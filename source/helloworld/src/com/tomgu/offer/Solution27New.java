package com.tomgu.offer;

import java.util.ArrayList;

public class Solution27New {

  private ArrayList<ArrayList<Integer>> ret = new ArrayList<>();

  public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
    backtracking(root, target, new ArrayList<>());
    return ret;
  }

  private void backtracking(TreeNode node, int target, ArrayList<Integer> path) {
    if (node == null) {
      return;
    }
    path.add(node.val);
    target -= node.val;
    if (target == 0 && node.left == null && node.right == null) {
      ret.add(new ArrayList<>(path));
    } else {
      backtracking(node.left, target, path);
      backtracking(node.right, target, path);
    }
    path.remove(path.size() - 1);
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
    System.out.println(new Solution27New().FindPath(n10, 22).size());
  }
}
