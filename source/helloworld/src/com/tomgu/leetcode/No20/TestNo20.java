package com.tomgu.leetcode.No20;

/**
 * Created by guzuxing on 04/01/2018.
 * Test 20
 */
public class TestNo20 {
  public static void main(String[] args) {
    String s = "([{()}()]{})";
    boolean result = Solution20.isValid(s);
    System.out.println(result == true);
    s = "([)]";
    result = Solution20.isValid(s);
    System.out.println(result == false);
  }
}
