package com.tomgu.algorithm.search.tree;

import java.util.Iterator;

/**
 * Created by guzuxing on 08/01/2018.
 * binary tree
 */
public class BinaryTree<T> implements BinaryTreeInterface<T> {

  private BinaryNode<T> root;

  public BinaryTree() {
    root = null;
  }

  public BinaryTree(T rootData) {
    root = new BinaryNode<T>(rootData);
  }

  public BinaryTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree) {
    privateSetTree(rootData, leftTree, rightTree);
  }

  public void setTree(T rootData) {
    root = new BinaryNode<>(rootData);
  }

  public void setTree(T rootData, BinaryTreeInterface<T> leftTree,
      BinaryTreeInterface<T> rightTree) {
    privateSetTree(rootData, (BinaryTree<T>) leftTree, (BinaryTree<T>) rightTree);
  }

  private void privateSetTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree) {
    root = new BinaryNode<T>(rootData);
    if (leftTree != null && !leftTree.isEmpty()) {
      root.setLeftChild(leftTree.root.copy());
    }
    if (rightTree != null && !rightTree.isEmpty()) {
      root.setRightChild(rightTree.root.copy());
    }
  }

  @Override
  public T getRootData() {
    T rootData = null;
    if (root != null) {
      rootData = root.getData();
    }
    return rootData;
  }

  protected void setRootData(T rootData) {
    root.setData(rootData);
  }

  protected void setRootNode(BinaryNode<T> rootNode) {
    root = rootNode;
  } // end setRootNode

  protected BinaryNode<T> getRootNode() {
    return root;
  } // end getRootNode

  @Override
  public int getHeight() {
    return root.getHeight();
  }

  @Override
  public int getNumberOfNodes() {
    return root.getNumberOfNodes();
  }

  @Override
  public boolean isEmpty() {
    return root == null;
  }

  @Override
  public void clear() {
    root = null;
  }
}
