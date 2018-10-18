package com.tomgu.offer;

public class Solution40 {

  public String LeftRotateString(String str, int n) {
    if (str == null || str.equals("")) {
      return "";
    }
    StringBuilder builder = new StringBuilder();
    char[] chars = str.toCharArray();
    for (int i = n; i < str.length(); i++) {
      builder.append(chars[i]);
    }
    for (int i = 0; i < n; i++) {
      builder.append(chars[i]);
    }
    return builder.toString();
  }

  public static void main(String[] args) {
    System.out.println(new Solution40().LeftRotateString("abcXYZdef", 3));
  }
}
