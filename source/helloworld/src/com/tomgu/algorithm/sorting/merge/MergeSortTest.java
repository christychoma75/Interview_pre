package com.tomgu.algorithm.sorting.merge;

import java.util.Arrays;

/**
 * Created by guzuxing on 03/01/2018.
 */
public class MergeSortTest {
  public static void main(String[] args) {
    Integer[] a = new Integer[] {7, 5, 9, 3, 6, 0, 2, 4};
    MergeSort sort = new MergeSort();
    sort.sort(a, a.length);
    Arrays.stream(a).forEach(System.out::println);
  }
}
