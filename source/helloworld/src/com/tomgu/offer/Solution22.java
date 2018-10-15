package com.tomgu.offer;

import java.util.ArrayList;

public class Solution22 {

  int[][] flag;
  ArrayList<Integer> result = new ArrayList<>();
  int total;

  public ArrayList<Integer> printMatrix(int[][] matrix) {

    if (matrix.length == 0) {
      return result;
    }

    if (matrix.length == 1) {
      for (int i = 0; i <= matrix[0].length - 1; i++) {
        result.add(matrix[0][i]);
      }
      return result;
    }

    flag = new int[matrix.length][matrix[0].length];
    total = matrix.length * matrix[0].length;
    add(matrix, 0, 0, 'r');
    return result;
  }

  public void add(int[][] matrix, int row, int col, char direction) {
    if (result.size() == total) {
      return;
    }

    char next;
    if (direction == 'r') {
      next = 'd';
      int index = col;
      for (index = col; index < flag[row].length; index++) {
        if (flag[row][index] == 1) {
          break;
        }
        flag[row][index] = 1;
        result.add(matrix[row][index]);
      }
      add(matrix, row + 1, index - 1, next);

    } else if (direction == 'd') {
      next = 'l';
      int index = row;
      for (index = row; index < flag.length; index++) {
        if (flag[index][col] == 1) {
          break;
        }
        flag[index][col] = 1;
        result.add(matrix[index][col]);
      }
      add(matrix, index - 1, col - 1, next);
    } else if (direction == 'l') {
      next = 'u';
      int index = col;
      for (index = col; index >= 0; index--) {
        if (flag[row][index] == 1) {
          break;
        }
        flag[row][index] = 1;
        result.add(matrix[row][index]);
      }
      add(matrix, row - 1, index + 1, next);
    } else {
      next = 'r';
      int index = row;
      for (index = row; index >= 0; index--) {
        if (flag[index][col] == 1) {
          break;
        }
        flag[index][col] = 1;
        result.add(matrix[index][col]);
      }
      add(matrix, index + 1, col + 1, next);
    }
  }

  public static void main(String[] args) {
    int flag = 0;
    int[][] a = new int[4][4];
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        a[i][j] = ++flag;
      }
    }
    new Solution22().printMatrix(a).stream().forEach(x -> System.out.println(x));
  }
}
