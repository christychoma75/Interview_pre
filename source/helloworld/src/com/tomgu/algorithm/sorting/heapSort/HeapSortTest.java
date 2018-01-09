package com.tomgu.algorithm.sorting.heapSort;

import com.tomgu.algorithm.sorting.insertion.InsertionSort;
import java.util.Arrays;

/**
 * Created by guzuxing on 09/01/2018.
 */
public class HeapSortTest {

  public static void main(String[] args) {
    Integer[] a = new Integer[]{20, 40, 30, 10, 90, 70};
    HeapSort sort = new HeapSort();
    sort.sort(a, 6);
    Arrays.stream(a).forEach(System.out::println);
  }
}