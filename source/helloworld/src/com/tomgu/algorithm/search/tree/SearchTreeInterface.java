package com.tomgu.algorithm.search.tree;

import com.tomgu.algorithm.search.tree.TreeInterface;
import java.util.Iterator;

/**
 * Created by guzuxing on 08/01/2018.
 * search tree interface
 */
public interface SearchTreeInterface<T extends Comparable<T>> extends TreeInterface<T> {
  
  boolean contains(T entry);
  
  T getEntry(T entry);
  
  T add(T newEntry);
  
  T remove(T entry);

}
