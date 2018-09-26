package com.tomgu.leetcode.No538;

import java.util.HashSet;
import java.util.Set;

public class Solution538 {

  public TreeNode convertBST(TreeNode root) {
    if (root == null) {
      return root;
    }

    if (root.left == null && root.right == null) {
      return root;
    }

    Set<Integer> values = new HashSet<>();
    getValues(values, root);
    convertNode(values, root);
    return root;
  }

  private void convertNode(Set<Integer> values, TreeNode root) {
    if (root == null) {
      return;
    }
    convertNode(values, root.left);
    convertNode(values, root.right);
    int old = root.val;
    for (Integer i : values) {
      if (i > old) {
        root.val += i;
      }
    }
  }

  private void getValues(Set<Integer> values, TreeNode root) {
    if (root == null) {
      return;
    }
    values.add(root.val);
    getValues(values, root.left);
    getValues(values, root.right);
  }


}
