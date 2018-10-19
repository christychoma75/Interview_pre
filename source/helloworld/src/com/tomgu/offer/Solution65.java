package com.tomgu.offer;

import java.util.HashMap;
import java.util.Map;

public class Solution65 {

  int index = 0;

  String Serialize(TreeNode root) {
    if (root == null) {
      return "";
    }
    Map<TreeNode, Integer> map = new HashMap<>();
    createNode2IndexMap(map, root);
    StringBuilder builder = new StringBuilder();
    buildTreeStr(builder, map, root);
    builder.deleteCharAt(builder.length() - 1);
    return builder.toString();
  }

  private void buildTreeStr(StringBuilder builder, Map<TreeNode, Integer> map, TreeNode root) {
    if (root == null) {
      return;
    }
    builder.append(map.get(root) + ",");
    builder.append(root.val);
    builder.append(",");
    if (root.left != null) {
      builder.append(map.get(root.left) + ",");
    } else {
      builder.append("0" + ",");
    }
    if (root.right != null) {
      builder.append(map.get(root.right) + ";");
    } else {
      builder.append("0" + ";");
    }
    buildTreeStr(builder, map, root.left);
    buildTreeStr(builder, map, root.right);
  }

  private void createNode2IndexMap(Map<TreeNode, Integer> map, TreeNode root) {
    if (root == null) {
      return;
    }
    index++;
    map.put(root, index);
    createNode2IndexMap(map, root.left);
    createNode2IndexMap(map, root.right);
  }

  TreeNode Deserialize(String str) {
    if (str.equals("")) {
      return null;
    }
    TreeNode root = null;

    String[] strs = str.split(";");
    Map<Integer, TreeNode> maps = new HashMap<>();
    for (String s : strs) {
      String[] tems = s.split(",");
      TreeNode node = new TreeNode(Integer.valueOf(tems[1]));
      Integer index = Integer.valueOf(tems[0]);
      maps.put(index, node);
    }

    for (String s : strs) {
      String[] tems = s.split(",");
      TreeNode node = maps.get(Integer.valueOf(tems[0]));
      if (Integer.valueOf(tems[2]) != 0) {
        node.left = maps.get(Integer.valueOf(tems[2]));
      }
      if (Integer.valueOf(tems[3]) != 0) {
        node.right = maps.get(Integer.valueOf(tems[3]));
      }
    }

    return maps.get(1);
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
    String str = new Solution65().Serialize(n8);
    System.out.println(str);
    TreeNode node = new Solution65().Deserialize(str);
    System.out.println(node);
  }

}
