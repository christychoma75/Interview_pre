package com.tomgu.leetcode.No461;

public class Solution461 {

  public int hammingDistance(int x, int y) {
    int dif = 0;
    int[] ax = new int[31];
    int[] bx = new int[31];
    getBits(ax, x);
    getBits(bx, y);
    for (int index = 0; index < ax.length; index++) {
      if (ax[index] != bx[index]) {
        dif = dif + 1;
      }
    }

    return dif;
  }

  private void getBits(int[] ax, int x) {
    int index = 0;
    while (x > 0) {
      ax[index] = x % 2;
      index = index + 1;
      x = x / 2;
    }
  }
}
