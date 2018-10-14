package com.tomgu.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by guzuxing on 2018/10/14.
 */
public class Solution19 {

  public Queue<TreeNode> queue = new LinkedList<>();

  public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
    ArrayList<Integer> list = new ArrayList<>();
    if (root == null) {
      return list;
    }
    list.add(root.val);
    if (root.left != null) {
      queue.offer(root.left);
    }
    if (root.right != null) {
      queue.offer(root.right);
    }
    while (!queue.isEmpty()) {
      TreeNode tem = queue.poll();
      list.add(tem.val);
      if (tem.left != null) {
        queue.offer(tem.left);
      }
      if (tem.right != null) {
        queue.offer(tem.right);
      }
    }
    return list;
  }

  public static void main(String[] args) {
    TreeNode n8 = new TreeNode(8);
    TreeNode n9 = new TreeNode(9);
    TreeNode n2 = new TreeNode(2);
    TreeNode n4 = new TreeNode(4);
    TreeNode n5 = new TreeNode(5);
    TreeNode n6 = new TreeNode(6);
    n8.left = n9;
    n8.right = n2;
    n9.right = n4;
    n2.left = n5;
    n5.right = n6;
    List<Integer> list = new Solution19().PrintFromTopToBottom(n8);
    list.stream().forEach(x -> System.out.println(x));
  }
}
