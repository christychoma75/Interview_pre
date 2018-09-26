package com.tomgu.leetcode.No169;

import java.util.HashMap;
import java.util.Map;

public class Solution169 {

  public int majorityElement(int[] nums) {
    Map<Integer, Integer> maps = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (maps.containsKey(nums[i])) {
        int size = maps.get(nums[i]);
        maps.put(nums[i], size + 1);
      } else {
        maps.put(nums[i], 1);
      }
    }

    int maxSize = 0;
    int result = 0;
    for (Integer key : maps.keySet()) {
      if (maps.get(key) > maxSize) {
        maxSize = maps.get(key);
        result = key;
      }
    }

    return result;
  }
}
