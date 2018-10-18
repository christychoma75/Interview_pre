package com.tomgu.offer;

public class Solution39 {

  public int NumberOf1Between1AndN_Solution(int n) {
    if (n == 0) {
      return 0;
    }
    if (n < 10) {
      return 1;
    }
    int result = 0;
    int[] num = new int[n + 2];
    int[] bit = new int[n + 2];
    num[0] = 0;
    bit[0] = 0;
    for (int i = 1; i <= 9; i++) {
      num[i] = i;
      bit[i] = 0;
    }
    bit[1] = 1;
    int base = 10;
    int pos = 10;
    int sum = 1;
    while (true) {
      int loopBase;
      int maxPosition = pos;
      for (int index = 1; index <= 9; index++) {
        loopBase = base * index;
        // treat first
        num[pos] = loopBase;
        if (loopBase > n) {
          return sum;
        }
        if (index == 1) {
          bit[pos] = 1;
          sum = sum + 1;
        } else {
          bit[pos] = 0;
        }
        pos++;
        for (int j = 1; j < maxPosition; j++) {
          if (num[j] + loopBase > n) {
            return sum;
          } else {
            num[pos] = num[j] + loopBase;
            if (index == 1) {
              bit[pos] = bit[j] + 1;
            } else {
              bit[pos] = bit[j];
            }
          }
          sum = sum + bit[pos];
          pos++;
        }
      }
      base = base * 10;
    }

  }

  public static void main(String[] args) {
    System.out.println(new Solution39().NumberOf1Between1AndN_Solution(19));
  }

}
