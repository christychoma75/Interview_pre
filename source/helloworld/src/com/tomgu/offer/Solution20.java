package com.tomgu.offer;

import java.util.Stack;

/**
 * Created by guzuxing on 2018/10/14.
 */
public class Solution20 {

  public boolean IsPopOrder(int[] pushA, int[] popA) {
    if (pushA.length == 0) {
      return true;
    }
    Stack<Integer> stack = new Stack<>();
    int popIndex = 0;
    for (int pushIndex = 0; pushIndex < pushA.length; pushIndex++) {
      stack.push(pushA[pushIndex]);
      while (!stack.isEmpty()) {
        if (popA[popIndex] == stack.peek()) {
          stack.pop();
          popIndex++;
        } else {
          break;
        }
      }
    }
    return stack.isEmpty();
  }

  public static void main(String[] args) {
    int[] a = {1, 2, 3, 4, 5};
    int[] b = {4, 5, 3, 2, 1};
    int[] c = {4, 3, 5, 1, 2};
    System.out.println(new Solution20().IsPopOrder(a, b));
    System.out.println(new Solution20().IsPopOrder(a, c));
  }

}
