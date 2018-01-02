package com.tomgu.algorithm.sorting.shell;

import com.tomgu.algorithm.sorting.ISort;

/**
 * Created by guzuxing on 02/01/2018.
 * shell sort
 */
public class ShellSort implements ISort {

  @Override
  public <T extends Comparable<T>> void sort(T[] a, int n) {
    shellSort(a, 0, n-1);
  }

  private <T extends  Comparable<T>> void shellSort(T[] a, int first, int last) {
    int n = a.length;
    int space = n/2;
    while (space > 0) {
      // sort sub_array
      for (int begin = first; begin <= first+space-1; begin++) {
        incrementalInsertion(a, begin, last, space);
      }
      space /=2;
    }
  }

  // sort sub_array as insertion sort
  private <T extends Comparable<T>> void incrementalInsertion(T[] a, int first, int last,
      int space) {
    for (int unsorted = first + space; unsorted <= last; unsorted = unsorted + space) {
      T next = a[unsorted];
      int index = unsorted - space;
      while (index >= first && next.compareTo(a[index])<0 ){
        // move back
        a[index+space] = a[index];
        index = index - space;
      }
      a[index + space] = next;
    }
  }
}
