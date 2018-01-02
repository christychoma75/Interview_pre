package com.tomgu.algorithm.sorting.insertion;

import com.tomgu.algorithm.sorting.ISort;

/**
 * Created by guzuxing on 02/01/2018.
 * Insertion sort
 */
public class InsertionSort implements ISort {

  @Override
  public <T extends Comparable<T>> void sort(T[] a, int n) {
    insertionSort(a, 0, n-1);
  }

  // insert from first to last
  private <T extends Comparable<T>> void insertionSort(T[] a, int first, int last) {
    for (int unsorted = first + 1; unsorted <= last; unsorted++) {
      T entry = a[unsorted];
      // pick up the current slot, and insert it -> current slot is empty
      insert(entry, a, first, unsorted-1);
    }
  }

  // insert entry to sorted part, starting from first to last
  private <T extends Comparable<T>> void insert(T entry, T[] a, int first, int last) {
    int position = last;
    while (position>=first && entry.compareTo(a[position])<0) {
      // entry < current, move the current back one slot
      a[position+1] = a[position];
      position--;
    }
    // current entry > entry, set the entry into current+1
    a[position+1] = entry;
  }
}
