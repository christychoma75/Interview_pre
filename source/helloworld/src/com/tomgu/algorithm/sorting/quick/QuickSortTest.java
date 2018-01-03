package com.tomgu.algorithm.sorting.quick;

import java.util.Arrays;

/**
 * Created by guzuxing on 03/01/2018.
 * test quick sort
 */
public class QuickSortTest {
  public static void main(String[] args) {
    Integer[] a = new Integer[] {3, 5, 0, 4, 6, 1, 2, 4};
    QuickSort sort = new QuickSort();
    sort.sort(a, a.length);
    Arrays.stream(a).forEach(System.out::println);
  }
}
