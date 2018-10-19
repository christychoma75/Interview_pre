package com.tomgu.offer;

public class Solution64 {

  public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
    if (str.length == 0) {
      return false;
    }
    if (matrix.length == 0) {
      return false;
    }
    char[][] matStr = new char[rows][cols];
    int index = 0;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        matStr[i][j] = matrix[index++];
      }
    }

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (matStr[i][j] == str[0]) {
          boolean[][] flag = new boolean[rows][cols];
          flag[i][j] = true;
          if (build(flag, matStr, str, i, j, 2)) {
            return true;
          }
        }
      }
    }

    return false;

  }

  private boolean build(boolean[][] flag, char[][] matStr, char[] str, int r, int c, int p) {
    if (p > str.length) {
      return true;
    }
    int tarR;
    int tarC;

    // check up
    tarR = r - 1;
    tarC = c;
    if (tarR >= 0 && matStr[tarR][tarC] == str[p - 1] && !flag[tarR][tarC]) {
      flag[tarR][tarC] = true;
      if (build(flag, matStr, str, tarR, tarC, p + 1)) {
        return true;
      }
      flag[tarR][tarC] = false;
    }

    // check right
    tarR = r;
    tarC = c + 1;
    if (tarC <= matStr[0].length - 1 && matStr[tarR][tarC] == str[p - 1] && !flag[tarR][tarC]) {
      flag[tarR][tarC] = true;
      if (build(flag, matStr, str, tarR, tarC, p + 1)) {
        return true;
      }
      flag[tarR][tarC] = false;
    }

    // check down
    tarR = r + 1;
    tarC = c;
    if (tarR <= matStr.length - 1 && matStr[tarR][tarC] == str[p - 1] && !flag[tarR][tarC]) {
      flag[tarR][tarC] = true;
      if (build(flag, matStr, str, tarR, tarC, p + 1)) {
        return true;
      }
      flag[tarR][tarC] = false;
    }

    // check left
    tarR = r;
    tarC = c - 1;
    if (tarC >= 0 && matStr[tarR][tarC] == str[p - 1] && !flag[tarR][tarC]) {
      flag[tarR][tarC] = true;
      if (build(flag, matStr, str, tarR, tarC, p + 1)) {
        return true;
      }
      flag[tarR][tarC] = false;
    }

    return false;
  }

  public static void main(String[] str) {
    System.out.println(new Solution64().hasPath(new char[]{'a', 'b', 'c', 'e', 's', 'f', 'c', 's',
        'a', 'd', 'e', 'e'}, 3, 4, new char[]{'a', 'b', 'c', 'b'}));
  }
}
