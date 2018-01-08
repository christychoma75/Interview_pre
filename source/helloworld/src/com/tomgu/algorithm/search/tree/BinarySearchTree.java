package com.tomgu.algorithm.search.tree;

import java.util.Iterator;

/**
 * Created by guzuxing on 08/01/2018.
 * binary search tree
 */
public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> implements
    SearchTreeInterface<T> {

  public BinarySearchTree() {
    super();
  }

  public BinarySearchTree(T rootEntry) {
    super();
    setRootNode(new BinaryNode<>(rootEntry));
  }

  @Override
  public boolean contains(T entry) {
    return getEntry(entry) != null;
  }

  @Override
  public T getEntry(T entry) {
    return findEntry(getRootNode(), entry);
  }

  private T findEntry(BinaryNode<T> rootNode, T entry) {
    T result = null;
    if (rootNode != null) {
      T rootEntry = rootNode.getData();
      if (entry.equals(rootEntry)) {
        result = rootEntry;
      } else if (entry.compareTo(rootEntry) < 0) {
        result = findEntry(rootNode.getLeftChild(), entry);
      } else {
        result = findEntry(rootNode.getRightChild(), entry);
      }
    }
    return result;
  }

  @Override
  public T add(T newEntry) {
    T result = null;
    if (isEmpty()) {
      setRootNode(new BinaryNode<T>(newEntry));
    } else {
      result = addEntry(getRootNode(), newEntry);
    }
    return result;
  }

  private T addEntry(BinaryNode<T> rootNode, T newEntry) {
    assert rootNode != null;
    T result = null;
    int comparison = newEntry.compareTo(rootNode.getData());
    if (comparison == 0) {
      result = rootNode.getData();
      rootNode.setData(newEntry);
    } else if (comparison < 0) {
      if (rootNode.hasLeft()) {
        result = addEntry(rootNode.getLeftChild(), newEntry);
      } else {
        rootNode.setLeftChild(new BinaryNode<T>(newEntry));
      }
    } else {
      assert comparison > 0;
      if (rootNode.hasRight()) {
        result = addEntry(rootNode.getRightChild(), newEntry);
      } else {
        rootNode.setRightChild(new BinaryNode<T>(newEntry));
      }
    } // end if
    return result;
  } // end addEntry


  @Override
  public T remove(T entry) {
    T oldEntry = (T) new Object();
    BinaryNode newRoot = removeEntry(getRootNode(), entry, oldEntry);
    setRootNode(newRoot);
    return oldEntry;
  }

  private BinaryNode removeEntry(BinaryNode<T> rootNode, T entry, T oldEntry) {
    if (rootNode != null) {
      T rootData = rootNode.getData();
      int comparison = entry.compareTo(rootData);
      if (comparison == 0) // entry == root entry
      {
        oldEntry = rootData;
        rootNode = removeFromRoot(rootNode);
      } else if (comparison < 0) // entry < root entry
      {
        BinaryNode<T> leftChild = rootNode.getLeftChild();

        BinaryNode<T> subtreeRoot = removeEntry(leftChild, entry, oldEntry);
        rootNode.setLeftChild(subtreeRoot);
      } else // entry > root entry
      {
        BinaryNode<T> rightChild = rootNode.getRightChild();

        rootNode.setRightChild(removeEntry(rightChild, entry, oldEntry));
      } // end if
    } // end if
    return rootNode;
  }

  private BinaryNode<T> removeFromRoot(BinaryNode<T> rootNode) {
    // Case 1: rootNode has two children
    if (rootNode.hasLeft() && rootNode.hasRight()) {
      // find node with largest entry in left subtree
      BinaryNode<T> leftSubtreeRoot = rootNode.getLeftChild();
      BinaryNode<T> largestNode = findLargest(leftSubtreeRoot);
      // replace entry in root
      rootNode.setData(largestNode.getData());
      // remove node with largest entry in left subtree
      rootNode.setLeftChild(removeLargest(leftSubtreeRoot));
    } // end if
    // Case 2: rootNode has at most one child
    else if (rootNode.hasRight()) {
      rootNode = rootNode.getRightChild();
    } else {
      rootNode = rootNode.getLeftChild();
    }
    // Assertion: if rootNode was a leaf, it is now null
    return rootNode;
  } // end removeEntry

  private BinaryNode<T> findLargest(BinaryNode<T> rootNode) {
    if (rootNode.hasRight()) {
      rootNode = findLargest(rootNode.getRightChild());
    }
    return rootNode;
  } // end findLargest

  // return the revised tree root node
  private BinaryNode<T> removeLargest(BinaryNode<T> rootNode) {
    if (rootNode.hasRight()) {
      BinaryNode<T> rightChild = rootNode.getRightChild();
      BinaryNode<T> root = removeLargest(rightChild);
      rootNode.setRightChild(root);
    } else {
      rootNode = rootNode.getLeftChild();
    }
    return rootNode;
  } // end removeLargest

}
