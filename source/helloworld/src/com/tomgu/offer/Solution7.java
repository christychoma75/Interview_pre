package com.tomgu.offer;

/**
 * Created by guzuxing on 2018/10/9.
 * f(n) = f(n-1)+f(n-2)+f(n-3)+...+f(1)+1
 */
public class Solution7 {

  public int JumpFloorII(int target) {
    if (target == 1) {
      return 1;
    }
    return (int) Math.pow(2, target - 1);
  }
}
