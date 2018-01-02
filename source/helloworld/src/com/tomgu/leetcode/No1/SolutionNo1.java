package com.tomgu.leetcode.No1;

import java.util.Arrays;

/**
 * Created by guzuxing on 01/01/2018.
 * https://leetcode.com/problems/two-sum/description/
 */
class SolutionNo1 {

  // Hints:

  /**
   search as bubble sort,
   for first = 1 to n-1
    for second = first+1 to n
      check num[first] + num[second]
   */

  static int[] twoSum(int[] nums, int target) {
    int pA, pB;
    int[] sorted = nums.clone();
    for (pA = 0; pA <= sorted.length -2; pA++){
      for (pB = pA + 1 ; pB <= sorted.length - 1; pB++) {
        if (sorted[pA] + sorted[pB] == target) {
          return new int[]{pA, pB};
        }
      }
    }
    return null;
  }

}
