package com.tomgu.algorithm.sorting.insertion;

import java.util.Arrays;

/**
 * Created by guzuxing on 02/01/2018.
 * Test insertion sort
 */
public class InsertionSortTest {
  public static void main(String[] args) {
    Integer[] a = new Integer[] {4, 7, 3, 2, -5, 8};
    InsertionSort sort = new InsertionSort();
    sort.sort(a, 6);
    Arrays.stream(a).forEach(System.out::println);
  }
}
