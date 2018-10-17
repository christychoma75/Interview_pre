package com.tomgu.offer;

public class Solution35New {

  // build from 1 -> next may be 2 or 3 or 5
  // then we get 1, 2 -> 2 used 1, therefore, next may be 2*2, 3*1, 5*1
  // 1,2,3 -> 2*2, 3*2, 5*1
  public int GetUglyNumber_Solution(int index) {
    int[] result = new int[index];
    result[0] = 1;
    int p2 = 0, p3 = 0, p5 = 0;
    int next2, next3, next5;
    int min;
    for (int i = 1; i < index; i++) {
      next2 = result[p2] * 2;
      next3 = result[p3] * 3;
      next5 = result[p5] * 5;
      min = Math.min(next2, Math.min(next3, next5));
      if (min == next2) {
        // use 2, 2 move forward
        p2++;
      }
      if (min == next3) {
        p3++;
      }
      if (min == next5) {
        p5++;
      }
      result[i] = min;
    }
    return result[index - 1];
  }

  public static void main(String[] args) {
    System.out.println(new Solution35New().GetUglyNumber_Solution(10));
  }
}
