package com.tomgu.leetcode.No20;

import java.util.Stack;

/**
 * Created by guzuxing on 04/01/2018.
 * https://leetcode.com/problems/valid-parentheses/description/
 *
 */
public class Solution20 {
  // ((
  // }
  // (}

  public static boolean isValid(String s) {
    if (s.length()%2 == 1) {
      return false;
    }

    Stack<Character> stack = new Stack<>();
    for (int index = 0; index < s.length(); index++) {
      char c = s.charAt(index);
      switch (c) {
        case '(':
        case '[':
        case '{':
          stack.push(c);
          break;
        case ')':
          if (stack.isEmpty()) {
            return false;
          }

          if (!stack.pop().equals('(')) {
            return false;
          }
          break;
        case ']':
          if (stack.isEmpty()) {
            return false;
          }

          if (!stack.pop().equals('[')) {
            return false;
          }
          break;
        case '}':
          if (stack.isEmpty()) {
            return false;
          }

          if (!stack.pop().equals('{')) {
            return false;
          }
          break;
        default:
          throw new UnsupportedOperationException("unsupported character" + c);

      }
    }

    if (!stack.isEmpty()) {
      return false;
    }

    return true;
  }
}
