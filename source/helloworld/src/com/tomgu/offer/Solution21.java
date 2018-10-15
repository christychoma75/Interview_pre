package com.tomgu.offer;

import java.util.Stack;

public class Solution21 {

  Stack<Integer> data = new Stack<>();
  // note minStack has to pop and push along with the data, so:
  // 1. push - min push the min currently
  // 2. pop - min pop
  Stack<Integer> minStack = new Stack<>();

  public void push(int node) {
    data.push(node);
    if (minStack.isEmpty()) {
      minStack.push(node);
    } else {
      minStack.push(minStack.peek() > node ? node : minStack.peek());
    }
  }

  public void pop() {
    data.pop();
    minStack.pop();
  }

  public int top() {
    return data.peek();
  }

  public int min() {
    return minStack.peek();
  }
}