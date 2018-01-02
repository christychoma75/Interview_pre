package com.tomgu.algorithm.sorting.shell;

import java.util.Arrays;

/**
 * Created by guzuxing on 02/01/2018.
 * test shell sort
 */
public class ShellSortTest {
  public static void main(String[] args) {
    Integer a[] = new Integer[]{10, 16, 11, 4, 15, 3, 9, 6, 1, 17, 8, 12, 7};
    ShellSort sort = new ShellSort();
    sort.sort(a, a.length);
    Arrays.stream(a).forEach(System.out::println);
  }
}
