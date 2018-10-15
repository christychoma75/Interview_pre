package com.tomgu.offer;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Solution25 {

  public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
    if (k > input.length || input.length == 0) {
      return new ArrayList<>();
    }
    PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
    for (int a : input) {
      queue.add(a);
      if (queue.size() > k) {
        queue.poll();
      }
    }
    return new ArrayList<>(queue);

  }
}
