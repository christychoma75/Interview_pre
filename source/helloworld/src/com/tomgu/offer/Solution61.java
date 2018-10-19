package com.tomgu.offer;

import java.util.Stack;

// return new String(str).matches("[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?");
public class Solution61 {

  // +num . num E + num
  public boolean isNumeric(char[] str) {
    boolean fPoint = false;
    boolean fE = false;
    Stack<Character> stack = new Stack<>();
    for (int index = 0; index < str.length; index++) {
      // point
      if (fPoint && str[index] == '.') {
        return false;
      }
      if (fE && !fPoint && str[index] == '.') {
        return false;
      }

      if (!fPoint && str[index] == '.') {
        fPoint = true;
        if (stack.isEmpty()) {
          continue;
        }
        if (!checkNum(stack, true)) {
          return false;
        } else {
          continue;
        }
      }

      // E
      if (fE && (str[index] == 'E' || str[index] == 'e')) {
        return false;
      }
      if (!fE && (str[index] == 'E' || str[index] == 'e')) {
        fE = true;
        if (fPoint) {
          if (stack.isEmpty()) {
            return false;
          }
          if (!checkNum(stack, false)) {
            return false;
          } else {
            continue;
          }
        } else {
          if (stack.isEmpty()) {
            return false;
          }
          if (!checkNum(stack, true)) {
            return false;
          } else {
            continue;
          }
        }
      }

      stack.add(str[index]);

    }
    if (fE && stack.isEmpty()) {
      return false;
    }
    return checkNum(stack, true);
  }

  private boolean checkNum(Stack<Character> stack, boolean b) {
    int size = stack.size();
    while (size > 1) {
      char c = stack.pop();
      if (c > '9' || c < '0') {
        return false;
      }
      size--;
    }
    char last = stack.pop();
    if (last <= '9' && last >= '0') {
      return true;
    }
    if (b) {
      if (last == '+' || last == '-') {
        return true;
      }
    }
    return false;
  }


  public static void main(String[] arg) {
    double d = Double.valueOf(".1E+1");
    System.out.println(d);
    d = Double.valueOf("1E+1");
    System.out.println(d);
    System.out.println(new Solution61().isNumeric("+12.23E-5".toCharArray()));
  }
}
