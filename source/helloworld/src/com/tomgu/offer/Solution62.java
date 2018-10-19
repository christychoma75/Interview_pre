package com.tomgu.offer;

import java.util.LinkedList;
import java.util.Queue;

public class Solution62 {

  int len;
  Queue<String> queue = new LinkedList<>();

  public boolean match(char[] str, char[] pattern) {
    if (str.length == 0) {
      return checkPattern(pattern);
    }
    if (str.length != 0 && pattern.length == 0) {
      return false;
    }

    len = str.length;
    for (int i = 0; i < pattern.length; i++) {
      if (i < pattern.length - 1 && pattern[i + 1] == '*') {
        append(str, pattern[i], true);
        i++;
      } else {
        append(str, pattern[i], false);
      }
    }

    while (!queue.isEmpty()) {
      String tem = queue.poll();
      if (checkSame(tem.toCharArray(), str)) {
        return true;
      }
    }

    return false;

  }

  private boolean checkSame(char[] build, char[] str) {
    if (build.length != str.length) {
      return false;
    }
    for (int i = 0; i < build.length; i++) {
      if (build[i] == '.') {
        continue;
      }
      if (build[i] != str[i]) {
        return false;
      }
    }
    return true;
  }

  private void append(char[] str, char c, boolean mul) {
    LinkedList<String> nQ = new LinkedList<>();
    if (queue.isEmpty()) {
      if (mul) {
        String tem = "";
        while (tem.length() <= len) {
          nQ.add(tem);
          tem = tem + c;
        }
      } else {
        nQ.add(new String() + c);
      }
    } else {
      while (!queue.isEmpty()) {
        String tem = queue.poll();
        if (mul && tem.length() == len && checkSame(tem.toCharArray(), str)) {
          nQ.add(tem);
        }

        if (tem.length() < len) {
          // append
          if (mul) {

            while (tem.length() <= len) {
              nQ.add(tem);
              tem = tem + c;
            }
          } else {
            nQ.add(tem + c);
          }
        }
      }
    }
    queue = nQ;
  }

  private boolean checkPattern(char[] ps) {
    if (ps.length == 0) {
      return false;
    }
    if (ps.length % 2 != 0) {
      return false;
    }
    for (int i = 1; i < ps.length - 1; i = i + 2) {
      if (ps[i] != '*') {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] arg) {
//    System.out.println(new Solution62().match("aaa".toCharArray(), "aa.a".toCharArray()));
//    System.out.println(new Solution62().match("aaa".toCharArray(), "ab*a".toCharArray()));
//    System.out.println(new Solution62().match("aaa".toCharArray(), "a.a".toCharArray()));
//    System.out.println(new Solution62().match("aaa".toCharArray(), "ab*ac*a".toCharArray()));
//    System.out.println(new Solution62().match("a".toCharArray(), ".*".toCharArray()));
//    System.out.println(new Solution62().match("a".toCharArray(), ".*.*".toCharArray()));
//    System.out.println(new Solution62().match("a".toCharArray(), "a.*.*".toCharArray()));
//    System.out.println(new Solution62().match("aaa".toCharArray(), "a*a".toCharArray()));
    System.out.println(new Solution62().match("a".toCharArray(), "ab*".toCharArray()));

  }
}
