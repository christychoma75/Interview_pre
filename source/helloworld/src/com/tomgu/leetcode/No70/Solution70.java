package com.tomgu.leetcode.No70;

public class Solution70 {

  public int climbStairs(int n) {
    if (n == 1) {
      return 1;
    }
    if (n == 2) {
      return 2;
    }
    if (n == 3) {
      return 3;
    }
    int pp = 2, p = 3;
    int c = 0;
    for (int i = 4; i <= n; i++) {
      c = p + pp;
      pp = p;
      p = c;
    }
    return c;
  }

  public static void main(String[] args) {
    System.out.println(new Solution70().climbStairs(6));
  }
}
