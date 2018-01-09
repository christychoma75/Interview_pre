package com.tomgu.algorithm.heap;

import java.util.Arrays;

/**
 * Created by guzuxing on 09/01/2018.
 * max heap
 */
public class MaxHeap<T extends Comparable<T>> implements MaxHeapInterface<T> {

  private T[] heap;
  private int lastIndex;
  private static final int DEFAULT_INITIAL_CAPACITY = 100;

  public MaxHeap() {
    this(DEFAULT_INITIAL_CAPACITY);
  }

  public MaxHeap(int capacity) {
    T[] temp = (T[]) new Comparable[capacity+1];
    heap = temp;
    lastIndex = 0;
  }

  public MaxHeap(T[] array) {
    T[] temp = (T[]) new Comparable[array.length+1];
    heap = temp;
    lastIndex = array.length;
    for (int index = 0; index < array.length; index++) {
      heap[index+1] = array[index];
    }
    // create heap by reheap from lastIndex/2 to 1
    for (int rootIndex = lastIndex/2; rootIndex > 0; rootIndex--) {
      reheap(rootIndex);
    }
  }

  @Override
  public void add(T newEntry) {
    lastIndex++;
    ensureCapacity();
    int nexIndex = lastIndex;
    int parentIndex = nexIndex/2;
    while (parentIndex > 0 && newEntry.compareTo(heap[parentIndex]) > 0) {
      heap[nexIndex] = heap[parentIndex];
      nexIndex = parentIndex;
      parentIndex = nexIndex/2;
    }
    heap[nexIndex] = newEntry;
  }

  private void ensureCapacity() {
    if (lastIndex >= heap.length) {
      heap = Arrays.copyOf(heap, 2*heap.length);
    }
  }

  @Override
  public T removeMax() {
    T root = null;
    if (! isEmpty()) {
      root = heap[1];
      heap[1] = heap[lastIndex];
      lastIndex--;
      reheap(1);
    }
    return root;
  }

  private void reheap(int rootIndex) {
    boolean done = false;
    T orphan = heap[rootIndex];
    int leftChildIndex = 2*rootIndex;
    while(!done && leftChildIndex<=lastIndex) {
      // has a child
      int largerChildIndex = leftChildIndex;
      int rightChildIndex = largerChildIndex+1;
      if (rightChildIndex<=lastIndex &&
          heap[rightChildIndex].compareTo(heap[largerChildIndex]) > 0) {
        // has right and right > left
        largerChildIndex = rightChildIndex;
      }

      if (orphan.compareTo(heap[largerChildIndex]) < 0) {
        // current < larger, move larger to parent
        heap[rootIndex] = heap[largerChildIndex];
        rootIndex = largerChildIndex;
        leftChildIndex = 2 * rootIndex;
      } else {
        done = true;
      }
    }
    // set the value
    heap[rootIndex] = orphan;
  }

  @Override
  public T getMax() {
    T root = null;
    if (!isEmpty()) {
      root = heap[1];
    }
    return root;
  }

  @Override
  public boolean isEmpty() {
    return lastIndex < 1;
  }

  @Override
  public int getSize() {
    return lastIndex;
  }

  @Override
  public void clear() {
    for (; lastIndex > -1; lastIndex--) {
      heap[lastIndex] = null;
    }
    lastIndex = 0;
  }
}
