package com.tomgu.offer;

public class Solution2 {

  public String replaceSpace(StringBuffer str) {
    //String result = str.toString().replaceAll(" ", "%20");
    StringBuffer buffer = new StringBuffer();
    for (char c : str.toString().toCharArray()) {
      if (c == ' ') {
        buffer.append("%20");
      } else {
        buffer.append(c);
      }
    }
    return buffer.toString();
  }

  public static void main(String[] str) {
    Solution2 s2 = new Solution2();
    StringBuffer buffer = new StringBuffer();
    buffer.append("We Are Happy.");
    System.out.println(s2.replaceSpace(buffer));
  }
}
