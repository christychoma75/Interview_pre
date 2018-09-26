package com.tomgu.leetcode.No338;

public class Solution338 {

  public int[] countBits(int num) {
    int[] result = new int[num + 1];
    result[0] = 0;
    if (num == 0) {
      return result;
    }
    result[1] = 1;
    if (num == 1) {
      return result;
    }

    int nextFlag = 4;
    int ptr = 0;
    for (int index = 2; index <= num; index++) {
      if (index == nextFlag) {
        nextFlag = index * 2;
        ptr = 0;
      }
      result[index] = result[ptr] + 1;
      ptr++;
    }
    return result;
  }

  public static void main(String[] args) {
    Solution338 s = new Solution338();
    System.out.println(s.countBits(14));
  }
}
