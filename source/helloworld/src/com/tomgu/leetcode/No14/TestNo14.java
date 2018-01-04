package com.tomgu.leetcode.No14;

/**
 * Created by guzuxing on 04/01/2018.
 * Test 14
 */
public class TestNo14 {
  public static void main(String[] args) {
    String[] strs = new String[]{"abcde", "abcfe", "acd"};
    String result = SolutionN14.longestCommonPrefix(strs);
    System.out.println(result.equals("a"));

    strs = new String[]{"abcde", "abcfe", "abc"};
    result = SolutionN14.longestCommonPrefix(strs);
    System.out.println(result.equals("abc"));
  }
}
