package com.tomgu.leetcode.No14;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guzuxing on 04/01/2018.
 * https://leetcode.com/problems/longest-common-prefix/description/
 */
public class SolutionN14 {

  // select the shortest'length
  // for each s, compare
  public static String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length==0) {
      return "";
    }
    List<Character> list = new ArrayList<>();
    int shortest = strs[0].length();
    String shortestStr = strs[0];
    for (String s : strs) {
      if (shortest > s.length()) {
        shortest = s.length();
        shortestStr = s;
      }
    }

    for (int index = 0; index < shortest; index++) {
      char c = shortestStr.charAt(index);
      for (String s : strs) {
        if (c != s.charAt(index)) {
          // return
          String result = "";
          for (Character ch : list) {
            result += ch;
          }
          return result;
        }
      }
      list.add(c);
    }

    return shortestStr;
  }
}
