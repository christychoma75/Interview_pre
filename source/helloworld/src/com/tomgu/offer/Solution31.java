package com.tomgu.offer;

public class Solution31 {

  int sum = 0;

  public int Sum_Solution(int n) {
    cal(n);
    return sum;
  }

  private int cal(int n) {
    sum += n;
    // n > 0; True
    boolean b = (n > 0) && sum > 0 && cal(n - 1) > 0;
    return n;
  }

  public static void main(String[] args) {
    System.out.println(new Solution31().Sum_Solution(5));
  }
}
