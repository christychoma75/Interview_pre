package com.tomgu.offer;

import java.util.HashSet;
import java.util.Iterator;

public class Solution34 {

  public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
    HashSet<Integer> set = new HashSet<>();
    for (int a : array) {
      if (set.contains(a)) {
        set.remove(a);
      } else {
        set.add(a);
      }
    }
    Iterator<Integer> it = set.iterator();
    num1[0] = it.next();
    num2[0] = it.next();
  }

  public static void main(String[] args) {
    int[] a = new int[1];
    int[] b = new int[1];
    new Solution34().FindNumsAppearOnce(new int[]{2, 4, 3, 6, 3, 2, 5, 5}, a, b);
    System.out.println(a[0]);
    System.out.println(b[0]);
  }
}
