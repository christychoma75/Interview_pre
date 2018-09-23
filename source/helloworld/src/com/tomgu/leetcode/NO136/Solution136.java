package com.tomgu.leetcode.NO136;

public class Solution136 {

  public int singleNumber(int[] nums) {
    int ans = 0;

    int len = nums.length;
    for (int i = 0; i != len; i++) {
      ans ^= nums[i];
    }

    return ans;
  }
}
