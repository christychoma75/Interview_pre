package com.tomgu.leetcode.No448;

import java.util.ArrayList;
import java.util.List;

public class Solution448 {

  public List<Integer> findDisappearedNumbers(int[] nums) {
    ArrayList<Integer> result = new ArrayList<>();
    if (nums.length == 0) {
      return result;
    }
    int currentIndex = 0;
    int position = nums[0];
    int tem;
    while (true) {
      if (nums[position - 1] == 0) {
        currentIndex = findNextPosition(currentIndex, nums);
        if (currentIndex >= nums.length) {
          break;
        }
        position = nums[currentIndex];
        continue;
      }
      tem = nums[position - 1];
      nums[position - 1] = 0;
      position = tem;
    }

    for (int index = 0; index < nums.length; index++) {
      if (nums[index] > 0) {
        result.add(index + 1);
      }
    }

    return result;
  }

  private int findNextPosition(int currentIndex, int[] nums) {
    int index = currentIndex + 1;
    for (; index < nums.length; index++) {
      if (nums[index] > 0) {
        return index;
      }
    }
    return index;
  }
}
