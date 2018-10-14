package com.tomgu.offer;

/**
 * Created by guzuxing on 2018/10/10.
 */
public class Solution15 {

  public double Power(double base, int exponent) {
    if (exponent == 0) {
      return 1;
    }
    if (exponent == 1) {
      return base;
    }
    boolean flag = true;
    if (exponent < 0) {
      exponent = -exponent;
      flag = false;
    }
    double result = Power(base, exponent / 2);
    result = result * result;
    if (exponent % 2 == 1) {
      result = result * base;
    }

    return flag ? result : 1 / result;
  }

  public static void main(String[] arg) {
    System.out.println(new Solution15().Power(2, 3));
  }
}
