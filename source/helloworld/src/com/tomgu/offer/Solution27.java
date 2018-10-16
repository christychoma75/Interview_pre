package com.tomgu.offer;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Solution27 {

  PriorityQueue<ArrayList<Integer>> result = new PriorityQueue<>((x, y) -> y.size() - x.size());

  public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
    build(root, target, new ArrayList<Integer>());
    ArrayList<ArrayList<Integer>> r = new ArrayList<>();
    while (!result.isEmpty()) {
      r.add(result.poll());
    }
    return r;
  }

  private void build(TreeNode root, int target, ArrayList<Integer> list) {
    if (root == null) {
      return;
    }
    int left = target - root.val;
    if (left < 0) {
      return;
    }
    // leaf node && target
    if (left == 0 && root.left == null && root.right == null) {
      list.add(root.val);
      result.add(new ArrayList<>(list));
      // remove the current root
      list.remove(list.size() - 1);
    }
    if (left > 0) {
      list.add(root.val);
      // left and right node
      build(root.left, left, list);
      build(root.right, left, list);
      // remove the current root
      list.remove(list.size() - 1);
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
    System.out.println(new Solution27().FindPath(n10, 15).size());
  }
}
