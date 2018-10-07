package com.tomgu.offer;

public class Solution1 {

  public boolean Find(int target, int[][] array) {
    int last = array[0].length;
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < last; j++) {
        if (target == array[i][j]) {
          return true;
        }
        if (target < array[i][j]) {
          last = j;
          break;
        }
      }
    }
    return false;
  }
}
