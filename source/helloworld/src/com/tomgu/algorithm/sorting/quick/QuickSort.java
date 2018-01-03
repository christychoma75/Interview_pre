package com.tomgu.algorithm.sorting.quick;

import com.tomgu.algorithm.sorting.ISort;

/**
 * Created by guzuxing on 03/01/2018.
 * quick sort
 */
public class QuickSort implements ISort {

  @Override
  public <T extends Comparable<T>> void sort(T[] a, int n) {
    quickSort(a, 0, n - 1);
  }

  private <T extends Comparable<T>> void quickSort(T[] a, int first, int last) {
    if (last <= first) {
      return;
    }
    if ((last - first) == 1) {
      if (a[last].compareTo(a[first]) < 0) {
        // swap
        T tem = a[last];
        a[last] = a[first];
        a[first] = tem;
        return;
      }
    }

    // quick sort
    int pivotIndex = partition(a, first, last);
    quickSort(a, first, pivotIndex - 1);
    quickSort(a, pivotIndex + 1, last);

  }

  private <T extends Comparable<T>> int partition(T[] a, int first, int last) {
    T pivot = a[last];
    int left = first;
    int right = last - 1;
    boolean done = false;
    while (!done) {
      while (a[left].compareTo(pivot) < 0) {
        left++;
      }
      while (a[right].compareTo(pivot) > 0) {
        right--;
      }
      if (left < right) {
        T tem = a[left];
        a[left] = a[right];
        a[right] = tem;
      } else {
        done = true;
      }
    }

    T tem = a[left];
    a[left] = pivot;
    a[last] = tem;
    return left;
  }
}
