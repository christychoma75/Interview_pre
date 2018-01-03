package com.tomgu.algorithm.sorting.merge;

import com.tomgu.algorithm.sorting.ISort;
import java.util.Arrays;
import java.util.StringJoiner;

/**
 * Created by guzuxing on 03/01/2018.
 * mergeSort
 */
public class MergeSort implements ISort {

  @Override
  public <T extends Comparable<T>> void sort(T[] a, int n) {
    T[] temArray = (T[]) new Comparable<?>[a.length];
    mergeSort(a, temArray, 0, n - 1);
  }

  private <T extends Comparable<T>> void mergeSort(T[] a, T[] temArray, int first, int last) {
    if (first < last) {
      int mid = (first + last) / 2;
      mergeSort(a, temArray, first, mid);
      mergeSort(a, temArray, mid + 1, last);
      merge(a, temArray, first, mid, last);
    }
  }

  private <T extends Comparable<T>> void merge(T[] a, T[] temArray, int first, int mid, int last) {
    int b1 = first, b2 = mid + 1, e1 = mid, e2 = last;
    int index = first;
    while ((b1 <= e1) && (b2 <= e2)) {
      if (a[b1].compareTo(a[b2]) < 0) {
        temArray[index] = a[b1];
        b1++;
      } else {
        temArray[index] = a[b2];
        b2++;
      }
      index++;
    }
    // copy left

      while (b1 <= e1) {
        temArray[index] = a[b1];
        b1++;
        index++;
      }



      while (b2 <= e2) {
        temArray[index] = a[b2];
        b2++;
        index++;
      }

    // copy from tem to a
    for (int i = first; i <= last; i++) {
      a[i] = temArray[i];
    }
    Arrays.stream(a).forEach(x -> System.out.print(x+" "));
    System.out.println();
  }
}
