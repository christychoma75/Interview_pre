package com.tomgu.offer;

import java.util.LinkedList;

public class Solution63 {

  class Pair {

    int row;
    int col;

    public Pair(int i, int j) {
      row = i;
      col = j;
    }
  }

  public int movingCount(int threshold, int rows, int cols) {
    if (threshold < 0) {
      return 0;
    }
    LinkedList<Pair> queue = new LinkedList<>();
    int count = 1;
    boolean[][] flag = new boolean[rows][cols];
    queue.add(new Pair(0, 0));
    flag[0][0] = true;
    while (!queue.isEmpty()) {
      Pair p = queue.pop();
      // up
      if (p.row - 1 >= 0 && !flag[p.row - 1][p.col]) {
        if (less(p.row - 1, p.col, threshold)) {
          count++;
          flag[p.row - 1][p.col] = true;
          queue.add(new Pair(p.row - 1, p.col));
        }
      }
      // right
      if (p.col + 1 < cols && !flag[p.row][p.col + 1]) {
        if (less(p.row, p.col + 1, threshold)) {
          count++;
          flag[p.row][p.col + 1] = true;
          queue.add(new Pair(p.row, p.col + 1));
        }
      }
      // down
      if (p.row + 1 < rows && !flag[p.row + 1][p.col] && less(p.row + 1, p.col, threshold)) {
        if (less(p.row + 1, p.col, threshold)) {
          count++;
          flag[p.row + 1][p.col] = true;
          queue.add(new Pair(p.row + 1, p.col));
        }
      }
      // left
      if (p.col - 1 >= 0 && !flag[p.row][p.col - 1]) {
        if (less(p.row, p.col - 1, threshold)) {
          count++;
          flag[p.row][p.col - 1] = true;
          queue.add(new Pair(p.row, p.col - 1));
        }
      }
    }
    return count;
  }

  private boolean less(int row, int col, int threshold) {
    int sum = 0;
    while (row > 0) {
      sum += row % 10;
      row /= 10;
    }
    while (col > 0) {
      sum += col % 10;
      col /= 10;
    }
    if (threshold >= sum) {
      return true;
    }
    return false;
  }

  public static void main(String[] arg) {
    System.out.println(new Solution63().movingCount(10, 1, 100));
  }
}
