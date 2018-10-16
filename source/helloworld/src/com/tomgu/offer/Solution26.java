package com.tomgu.offer;

public class Solution26 {

  public int FindGreatestSumOfSubArray(int[] array) {
    if (array.length == 0) {
      return 0;
    }
    if (array.length == 1) {
      return array[0];
    }

    int result[] = new int[array.length];
    int maxIndex = array.length - 1;
    result[maxIndex] = array[maxIndex];
    int max = result[maxIndex];
    for (int i = maxIndex - 1; i >= 0; i--) {
      if (array[i] + result[i + 1] > array[i]) {
        result[i] = array[i] + result[i + 1];
      } else {
        result[i] = array[i];
      }
      if (max < result[i]) {
        max = result[i];
      }

    }
    return max;
  }

  public static void main(String[] args) {
    System.out.println(new Solution26().FindGreatestSumOfSubArray(new int[]{
        6, -3, -2, 7, -15, 1, 2, 3}));
  }
}
