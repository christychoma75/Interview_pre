package com.tomgu.leetcode.No7;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by guzuxing on 01/02/2018.
 * https://leetcode.com/problems/reverse-integer/description/
 */
class SolutionNo7 {

  // Hints:

  /**
      flag sign bit
      put each bit into a queue
      pop from head to compute the new number
      check overflow
   */

  static int reverse(int x) {
    if (x == 0) {
      return 0;
    }

    boolean signed = true;
    if (x < 0) {
      signed = false;
      x *= -1;
    }

    Queue<Integer> queue = new LinkedBlockingQueue<>();
    while (x > 0) {
      queue.add(x%10);
      x = x/10;
    }

    long result = 0L;
    while (!queue.isEmpty()) {
      result = result*10 + queue.poll();
    }

    if (!signed) {
      result *=-1;
    }

    if (result > Integer.MAX_VALUE) {
      return 0;
    }

    if (result < Integer.MIN_VALUE) {
      return 0;
    }

    return ((int) result);

  }

}
