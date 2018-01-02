package com.tomgu.algorithm.sorting;

/**
 * Created by guzuxing on 02/01/2018.
 */
public interface ISort {
  // sort array
  <T extends Comparable<T>> void sort(T[]a, int n);
}
