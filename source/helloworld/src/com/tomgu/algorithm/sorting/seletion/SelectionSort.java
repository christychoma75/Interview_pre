package com.tomgu.algorithm.sorting.seletion;

import com.tomgu.algorithm.sorting.ISort;

/**
 * Created by guzuxing on 02/01/2018.
 */
public class SelectionSort implements ISort {

  @Override
  public <T extends Comparable<T>> void sort(T[] a, int n) {
    for (int index = 0; index < n-1; index++) {
      int indexOfSmallest = findSmallest(a, index, n-1);
      swap(a, index, indexOfSmallest);
    }
  }


  // find the smallest index from index to last
  private <T extends Comparable<T>> int findSmallest(T[] a, int first, int last) {
    T min = a[first];
    int indexOfSmallest = first;
    for (int index = first+1; index <= last; index++) {
      if (a[index].compareTo(min) < 0) {
        indexOfSmallest = index;
        min = a[index];
      }
    }
    return indexOfSmallest;
  }


  // swap pA and pB
  private <T extends Comparable<T>> void swap(T[] a, int pA, int pB) {
    T temp = a[pA];
    a[pA] = a[pB];
    a[pB] = temp;
  }

}
