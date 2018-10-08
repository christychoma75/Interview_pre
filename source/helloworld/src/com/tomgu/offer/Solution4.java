package com.tomgu.offer;

public class Solution4 {
  public int JumpFloor(int target) {
    if (target == 1) return 1;
    if (target == 2) return 2;
    int result = 0;
    int p2 = 1;
    int p1 = 2;
    int tem;
    for (int flag = 3; flag <= target; flag++) {
      tem = p1;
      p1 = tem+p2;
      p2 = tem;
    }
    return p1;
  }
}
