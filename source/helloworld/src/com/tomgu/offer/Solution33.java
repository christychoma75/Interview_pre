package com.tomgu.offer;

public class Solution33 {

  public int GetNumberOfK(int[] array, int k) {
    int sum = 0;
    boolean flag = false;
    for (int a : array) {
      if (a != k && !flag) {
        continue;
      }
      if (a != k && flag) {
        return sum;
      }
      if (flag) {
        flag = true;
      }
      sum++;
    }
    return sum;
  }
}
