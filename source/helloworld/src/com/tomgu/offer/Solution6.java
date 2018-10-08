package com.tomgu.offer;

import java.util.Stack;

public class Solution6 {
  Stack<Integer> stack1 = new Stack<Integer>();
  Stack<Integer> stack2 = new Stack<Integer>();

  public void push(int node) {
    stack1.add(node);
  }

  public int pop() {
    if(stack2.empty()) {
      move();
    }
    return stack2.pop();
  }

  private void move() {
    // move stack1 to stack2
    while(!stack1.empty()) {
      stack2.push(stack1.pop());
    }
  }


}
