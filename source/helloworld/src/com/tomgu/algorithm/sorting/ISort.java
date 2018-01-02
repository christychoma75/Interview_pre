package com.tomgu.algorithm.sorting;

/**
 * Created by guzuxing on 02/01/2018.
 * interface of all sort
 */
public interface ISort {
  /**
   * sort array
   * @param a array
   * @param n size of array
   * @param <T> entry type
   */
  <T extends Comparable<T>> void sort(T[]a, int n);
}
