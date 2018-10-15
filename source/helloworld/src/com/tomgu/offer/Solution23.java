package com.tomgu.offer;

public class Solution23 {

  public int MoreThanHalfNum_Solution(int[] array) {
    int num = 0;
    int count = 0;
    for (int a : array) {
      if (count == 0) {
        count++;
        num = a;
      }

      if (num == a) {
        count++;
      } else {
        count--;
      }
    }

    // num is the most frequently number
    count = 0;
    for (int a : array) {
      if (a == num) {
        count++;
      }
    }
    int majority = array.length / 2 + 1;
    return count >= majority ? num : 0;
  }
}
