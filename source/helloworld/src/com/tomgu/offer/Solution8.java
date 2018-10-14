package com.tomgu.offer;

/**
 * Created by guzuxing on 2018/10/9.
 */
public class Solution8 {

  public int minNumberInRotateArray(int[] array) {
    if (array.length == 0) {
      return 0;
    }
    if (array.length == 1) {
      return array[1];
    }
    if (array.length == 2) {
      return Math.min(array[0], array[1]);
    }
    return find(array, 0, array.length - 1);
  }

  private int find(int[] array, int s, int e) {
    if (s == e) {
      return array[s];
    }
    if (s - e == 1) {
      return Math.min(array[s], array[e]);
    }
    int m = (s + e) / 2;
    // at left: 5 1 2 3 4
    if (array[s] > array[m] && array[m] < array[e]) {
      return find(array, s, m);
    }

    // at right: 34512
    if (array[s] < array[m] && array[m] > array[e]) {
      return find(array, m, e);
    }

    return findInOrder(array, s, e);
  }

  private int findInOrder(int[] array, int s, int e) {
    int k = array[s];
    for (int i = s + 1; i <= e; i++) {
      if (array[i] < k) {
        k = array[i];
      }
    }
    return k;
  }

  public static void main(String[] args) {
    System.out.println(new Solution8().minNumberInRotateArray(new int[]{3, 4, 5, 1, 2}));
    System.out.println(new Solution8().minNumberInRotateArray(new int[]{1, 0, 1, 1, 1}));
    System.out.println(new Solution8().minNumberInRotateArray(new int[]{1, 1, 1, 0, 1}));
    System.out.println(new Solution8().minNumberInRotateArray(new int[]{1, 2, 3, 4, 5}));
  }
}
