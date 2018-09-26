package com.tomgu.leetcode.No283;

public class Solution283 {

  public void moveZeroes(int[] nums) {
    if (nums.length <= 1) {
      return;
    }
    int[] nNums = new int[nums.length];
    for (int index = 0; index < nums.length; index++) {
      nNums[index] = 0;
    }

    for (int index = 0; index < nums.length; index++) {
      if (nums[index] != 0) {
        nNums[index] = nums[index];
      }
    }

    for (int index = 0; index < nums.length && nNums[index] != 0; index++) {
      nums[index] = nNums[index];
    }
  }
}
