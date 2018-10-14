package com.tomgu.offer;

import java.util.Arrays;

/**
 * Created by guzuxing on 2018/10/10.
 */
public class Solution13 {

  public void reOrderArray(int[] array) {
    int[] copy = new int[array.length];
    if (array.length <= 1) {
      return;
    }
    int odd = 0;
    int even = array.length - 1;
    for (int i = 0; i < array.length; i++) {
      if (array[i] % 2 == 1) {
        copy[odd] = array[i];
        odd++;
      }
    }
    for (int i = array.length - 1; i >= 0; i--) {
      if (array[i] % 2 == 0) {
        copy[even] = array[i];
        even--;
      }
    }
    for (int i = 0; i < array.length; i++) {
      array[i] = copy[i];
    }
  }

  public static void main(String[] args) {
    int[] a = {1, 4, 3, 2, 5};
    new Solution13().reOrderArray(a);
    Arrays.stream(a).forEach(x -> System.out.println(x));
  }
}
