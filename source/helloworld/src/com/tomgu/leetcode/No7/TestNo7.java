package com.tomgu.leetcode.No7;

/**
 * Created by guzuxing on 01/01/2018.
 * https://leetcode.com/problems/two-sum/description/
 */
public class TestNo7 {
  public static void main(String[] args) {
    int x = 321;
    int y = SolutionNo7.reverse(x);
    System.out.println(y == 123);
    x = 120;
    y = SolutionNo7.reverse(x);
    System.out.println(y == 21);
  }

}
