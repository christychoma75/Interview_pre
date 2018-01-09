package com.tomgu.algorithm.search.tree;

/**
 * Created by guzuxing on 08/01/2018.
 * binary tree interface
 */
public interface BinaryTreeInterface<T> extends TreeInterface<T> {
  public void setTree(T rootData);
  public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree);
}
