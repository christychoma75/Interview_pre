package com.tomgu.algorithm.sorting.selection;

import java.util.Arrays;

/**
 * Created by guzuxing on 02/01/2018.
 * Test selection sort
 */
public class SelectionSortTest {
  public static void main(String[] args) {
    Integer[] a = new Integer[] {4, 7, 3, 2, -5, 8};
    SelectionSort sort = new SelectionSort();
    sort.sort(a, 6);
    Arrays.stream(a).forEach(System.out::println);
  }
}
