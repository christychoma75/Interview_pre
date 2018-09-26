package com.tomgu.leetcode.No448;

import java.util.List;

public class TestNo448 {

  public static void main(String[] args) {
    Solution448 s = new Solution448();
    int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
    List result = s.findDisappearedNumbers(nums);
    System.out.println(result);
  }
}
