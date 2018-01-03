package com.tomgu.leetcode.No9;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by guzuxing on 03/01/2018.
 * https://leetcode.com/problems/palindrome-number/description/
 */
class SolutionNo9 {
  static boolean isPalindrome(int x) {
    if (x < 0) {
      return false;
    }

    long y = (long)x;
    if (y < 10) {
      return true;
    }

    Deque<Integer> deque = new LinkedList<>();
    while(y > 0) {
      deque.add((int)y%10);
      y /= 10;
    }

    // check front and end
    while (deque.size() > 1) {
      int front = deque.pollLast();
      int end = deque.pollFirst();
      if (front != end) {
        return false;
      }
    }

    return true;
  }
}
