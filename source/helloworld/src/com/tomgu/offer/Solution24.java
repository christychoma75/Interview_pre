package com.tomgu.offer;

public class Solution24 {

  public boolean VerifySquenceOfBST(int[] sequence) {
    if (sequence.length == 0) {
      return false;
    }
    if (sequence.length <= 2) {
      return true;
    }
    return check(sequence, 0, sequence.length - 1);
  }

  private boolean check(int[] sequence, int s, int e) {
    if (e < s || e == s + 1 || e == s) {
      return true;
    }
    int lIndex = s;
    int rIndex = e;
    int root = sequence[e];
    for (; lIndex < e; lIndex++) {
      if (sequence[lIndex] < root) {
        continue;
      } else {
        break;
      }
    }
    for (rIndex = e - 1; rIndex >= s; rIndex--) {
      if (sequence[rIndex] > root) {
        continue;
      } else {
        break;
      }
    }
    lIndex = lIndex - 1;
    rIndex = rIndex + 1;
    if (lIndex != rIndex - 1) {
      return false;
    }

    return check(sequence, s, lIndex) && check(sequence, rIndex, e - 1);
  }

  public static void main(String[] arg) {
    System.out.println(new Solution24().VerifySquenceOfBST(new int[]{3, 4, 1, 8, 9, 7, 13, 10, 5}));
  }
}
