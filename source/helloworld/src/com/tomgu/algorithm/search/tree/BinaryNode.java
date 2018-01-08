package com.tomgu.algorithm.search.tree;

/**
 * Created by guzuxing on 08/01/2018.
 * binary node
 */
public class BinaryNode<T> {

  private T data;
  private BinaryNode<T> leftChild;
  private BinaryNode<T> rightChild;

  public BinaryNode() {
    this(null);
  }

  public BinaryNode(T dt) {
    this(dt, null, null);
  }

  public BinaryNode(T dt, BinaryNode<T> left, BinaryNode<T> right) {
    this.data = dt;
    this.leftChild = left;
    this.rightChild = right;
  }

  public T getData() {
    return data;
  }

  public void setData(T dt) {
    this.data = dt;
  }

  public BinaryNode<T> getLeftChild() {
    return leftChild;
  }

  public BinaryNode<T> getRightChild() {
    return rightChild;
  }

  public void setLeftChild(BinaryNode<T> nLeft) {
    leftChild = nLeft;
  }

  public void setRightChild(BinaryNode<T> nRight) {
    rightChild = nRight;
  }

  public boolean hasLeft() {
    return leftChild != null;
  }

  public boolean hasRight() {
    return rightChild != null;
  }

  public boolean isLeaf() {
    return (leftChild == null) && (rightChild == null);
  }

  public BinaryNode<T> copy() {
    BinaryNode<T> newRoot = new BinaryNode<T>(data);
    if (leftChild != null) {
      newRoot.leftChild = (BinaryNode<T>) leftChild.copy();
    }
    if (rightChild != null) {
      newRoot.rightChild = (BinaryNode<T>) rightChild.copy();
    }
    return newRoot;
  } // end copy

  public int getHeight() {
    return getHeight(this);
  }

  private int getHeight(BinaryNode<T> node) {
    int height = 0;
    if (node != null)
      height = 1 + Math.max(getHeight(node.leftChild),
          getHeight(node.rightChild));
    return height;
  }

  public int getNumberOfNodes() {
    return getNumberOfNodes(this);
  }

  private int getNumberOfNodes(BinaryNode<T> node) {
    int leftNumber = 0; int rightNumber = 0;
    if (leftChild != null)
      leftNumber = leftChild.getNumberOfNodes();
    if (rightChild != null)
      rightNumber = rightChild.getNumberOfNodes();
    return 1 + leftNumber + rightNumber;
  }
}
