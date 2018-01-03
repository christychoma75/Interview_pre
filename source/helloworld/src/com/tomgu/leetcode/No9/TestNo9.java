package com.tomgu.leetcode.No9;

/**
 * Created by guzuxing on 03/01/2018.
 * Test: Solution9
 */
public class TestNo9 {
  public static void main(String[] args) {
    Integer x = 123454321;
    boolean result = SolutionNo9.isPalindrome(x);
    System.out.println(result == true);
    x = -2147447412;
    result = SolutionNo9.isPalindrome(x);
    System.out.println(result == false);
    x = -2147483648;
    result = SolutionNo9.isPalindrome(x);
    System.out.println(result == false);
  }
}
