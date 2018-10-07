package com.tomgu.leetcode.No121;

public class Solution121 {

  public int maxProfit(int[] prices) {
    if (prices == null || prices.length == 0 || prices.length == 1) {
      return 0;
    }
    int max = 0;
    int cLow = prices[0];
    for (int index = 1; index < prices.length; index++) {
      if (cLow > prices[index]) {
        cLow = prices[index];
      } else {
        max = Math.max(max, prices[index] - cLow);
      }
    }
    return max;
  }

  public static void main(String[] args) {
    Solution121 s = new Solution121();
    int[] a = new int[]{7, 1, 5, 3, 6, 4};
    System.out.println(s.maxProfit(a));
  }
}
