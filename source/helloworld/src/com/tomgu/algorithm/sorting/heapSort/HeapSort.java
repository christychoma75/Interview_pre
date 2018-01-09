package com.tomgu.algorithm.sorting.heapSort;

import com.tomgu.algorithm.heap.MaxHeap;
import com.tomgu.algorithm.sorting.ISort;
import java.util.Arrays;

/**
 * Created by guzuxing on 09/01/2018.
 * heap sort
 */
public class HeapSort implements ISort {

  @Override
  public <T extends Comparable<T>> void sort(T[] a, int n) {
    MaxHeap<T> heap = new MaxHeap(a);
    T[] result = Arrays.copyOf(a, n);
    for (int index = result.length-1; index>=0; index--) {
      T entry = (T) heap.removeMax();
      result[index] = entry;
    }

    for (int index = 0; index < a.length; index++) {
      a[index] = result[index];
    }
  }
}
