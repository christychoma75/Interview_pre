package com.tomgu.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Solution30 {

  ArrayList<String> ret = new ArrayList<>();
  HashSet<String> contains = new HashSet<>();

  public ArrayList<String> Permutation(String str) {

    if (str.length() == 0) {
      return ret;
    }

    char[] chars = str.toCharArray();
    boolean[] flags = new boolean[chars.length];
    Arrays.sort(chars);
    buildStr(chars, flags, new StringBuffer());
    return ret;
  }

  private void buildStr(char[] chars, boolean[] flags, StringBuffer stringBuffer) {
    if (stringBuffer.length() == chars.length) {
      if (contains.contains(stringBuffer.toString())) {
        return;
      }
      ret.add(stringBuffer.toString());
      contains.add(stringBuffer.toString());
      return;
    }

    for (int index = 0; index < chars.length; index++) {
      // set current location
      if (flags[index]) {
        continue;
      } else {
        flags[index] = true;
        stringBuffer.append(chars[index]);
        buildStr(chars, flags, stringBuffer);
        flags[index] = false;
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
      }
    }
  }

  public static void main(String[] arg) {
    new Solution30().Permutation("aac").stream().forEach(x -> System.out.println(x));
  }
}
