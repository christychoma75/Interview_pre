package com.tomgu.offer;

import java.util.ArrayList;

public class Solution38 {

  public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {

    if (array.length < 1) {
      return new ArrayList<>();
    }

    int a = array[array.length - 1];
    int b = array[array.length - 1];
    boolean flag = false;
    int aI = 0;
    int bI = array.length - 1;
    while (aI < bI) {
      if (array[aI] + array[bI] > sum) {
        bI--;
      } else if (array[aI] + array[bI] < sum) {
        aI++;
      } else {
        flag = true;
        if (array[aI] * array[bI] < a * b) {
          a = array[aI];
          b = array[bI];
        }
        aI++;
        bI--;
      }
    }
    ArrayList<Integer> rst = new ArrayList<>();
    if (flag) {
      rst.add(a);
      rst.add(b);
    }
    return rst;
  }


  public static void main(String[] arg) {
    System.out
        .println(new Solution38().FindNumbersWithSum(new int[]{1, 2, 4, 7, 11, 16}, 17).get(0));
  }
}
