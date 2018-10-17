package com.tomgu.offer;


public class Solution35 {

  public int GetUglyNumber_Solution(int index) {
    switch (index) {
      case 1:
        return 1;
      case 2:
        return 2;
      case 3:
        return 3;
      case 4:
        return 4;
      case 5:
        return 5;
      default:
        return get(index - 5, 6);
    }

  }

  private int get(int leftIndex, int start) {
    int found = 0;
    while (true) {
      if (leftIndex == 0) {
        return found;
      }
      found = next(start);
      start = found + 1;
      leftIndex--;
    }
  }

  private int next(int start) {
    while (true) {
      if (check(start)) {
        return start;
      }
      start++;
    }
  }

  private boolean check(int start) {
    while (start % 5 == 0) {
      start = start / 5;
    }
    while (start % 3 == 0) {
      start = start / 3;
    }
    while (start % 2 == 0) {
      start = start / 2;
    }
    return start == 1 ? true : false;
  }

  public static void main(String[] arg) {
    System.out.println(new Solution35().GetUglyNumber_Solution(13));
  }
}
