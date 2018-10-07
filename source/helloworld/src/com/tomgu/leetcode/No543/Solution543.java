package com.tomgu.leetcode.No543;

import java.util.HashMap;
import java.util.Map;

public class Solution543 {

  int ans = 0;
  Map<TreeNode, Integer> depthMaps = new HashMap<>();

  public int diameterOfBinaryTree(TreeNode root) {
    ans = 0;
    depth(root);
    return ans - 1;
  }

  private int depth(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int lLegth = 0;
    if (root.left != null) {
      if (depthMaps.containsKey(root.left)) {
        lLegth = depthMaps.get(root.left);
      } else {
        lLegth = depth(root.left);
        depthMaps.put(root.left, lLegth);
      }
    }

    int rLegth = 0;
    if (root.right != null) {
      if (depthMaps.containsKey(root.right)) {
        rLegth = depthMaps.get(root.right);
      } else {
        rLegth = depth(root.right);
        depthMaps.put(root.right, rLegth);
      }
    }

    ans = Math.max(ans, lLegth + rLegth + 1);
    return Math.max(lLegth, rLegth) + 1;
  }


}
