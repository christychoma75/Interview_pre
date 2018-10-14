package com.tomgu.offer;

/**
 * Created by guzuxing on 2018/10/9.
 */
public class Solution9 {

  public int NumberOf1(int n) {
    if (n == 0) {
      return 0;
    }
    if (n > 0) {
      return cal(n);
    }
    return cal(Integer.MAX_VALUE + n + 1) + 1;
  }

  private int cal(int i) {
    int result = 0;
    while (i > 0) {
      result = result + (i & 1);
      i = i >> 1;
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(new Solution9().NumberOf1(5));
    System.out.println(new Solution9().NumberOf1(-5));
  }
}
