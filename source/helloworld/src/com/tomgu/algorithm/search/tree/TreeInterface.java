package com.tomgu.algorithm.search.tree;

/**
 * Created by guzuxing on 08/01/2018.
 * tree interface
 */
public interface TreeInterface<T> {
  T getRootData();

  int getHeight();

  int getNumberOfNodes();

  boolean isEmpty();

  void clear();
}
