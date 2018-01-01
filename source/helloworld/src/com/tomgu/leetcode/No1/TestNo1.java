package com.tomgu.leetcode.No1;

/**
 * Created by guzuxing on 01/01/2018.
 * https://leetcode.com/problems/two-sum/description/
 */
public class TestNo1 {
  public static void main(String[] args) {
    int[] nums = new int[]{2, 7, 11, 15};
    int target = 9;
    int[] result = Solution.twoSum(nums, target);
    assert result.length == 2;
    assert result[0] == 0 && result[1] == 1;
  }

}
