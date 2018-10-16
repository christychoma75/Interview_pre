package com.tomgu.offer;

public class Solution29 {

  public int FirstNotRepeatingChar(String str) {
    int[] flag = new int[256];
    if (str.length() == 1) {
      return 0;
    }
    char[] strs = str.toCharArray();
    for (int i = 0; i < 256; i++) {
      flag[i] = 1002;// not occur
    }
    for (int i = 0; i < strs.length; i++) {
      char c = strs[i];
      if (flag[c] == 1002) {
        flag[c] = i;
      } else {
        flag[c] = 1001;
      }
    }
    int resultPosition = 1001;
    for (int i = 65; i <= 129; i++) {
      if (flag[i] < resultPosition) {
        resultPosition = flag[i];
      }
    }
    return resultPosition == 1001 ? -1 : resultPosition;
  }
}
