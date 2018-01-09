package com.tomgu.algorithm.heap;

/**
 * Created by guzuxing on 09/01/2018.
 * max heap interface
 */
public interface MaxHeapInterface<T extends Comparable<T>> {
  void add(T newEntry);
  T removeMax();
  T getMax();
  boolean isEmpty();
  int getSize();
  void clear();
}
