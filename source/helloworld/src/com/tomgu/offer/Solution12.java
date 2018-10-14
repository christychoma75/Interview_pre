package com.tomgu.offer;

/**
 * Created by guzuxing on 2018/10/10.
 */
public class Solution12 {

  public int RectCover(int target) {
    if (target == 0) {
      return 0;
    }
    if (target == 1) {
      return 1;
    }
    if (target == 2) {
      return 2;
    }
    int f = 1;
    int g = 2;
    int tem;
    for (int i = 3; i <= target; i++) {
      tem = f + g;
      f = g;
      g = tem;
    }

    return g;
  }
}
