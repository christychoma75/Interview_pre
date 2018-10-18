package com.tomgu.offer;

public class Solution37 {

  int size = 0;
  String result = null;

  public String PrintMinNumber(int[] numbers) {
    boolean flag[] = new boolean[numbers.length];
    for (int a : numbers) {
      size += len(a);
    }

    build(numbers, flag, new StringBuffer());
    return result;
  }

  private void build(int[] numbers, boolean[] flag, StringBuffer stringBuffer) {
    String tem = stringBuffer.toString();
    if (result == null) {
      if (tem.length() == size) {
        result = tem;
        return;
      } else {
        // do nothing
      }
    } else {
      if (result.compareTo(tem) > 0) {
        result = null;
      } else {
        return;
      }
    }

    for (int index = 0; index < numbers.length; index++) {
      if (flag[index]) {
        continue;
      }
      stringBuffer.append(String.valueOf(numbers[index]));
      flag[index] = true;
      build(numbers, flag, stringBuffer);
      flag[index] = false;
      stringBuffer.delete(stringBuffer.length() - len(numbers[index]), stringBuffer.length());
    }
  }

  int len(int a) {
    int result = 0;
    while (a > 0) {
      result++;
      a /= 10;
    }
    return result;
  }

  public static void main(String[] arg) {
    System.out.println(new Solution37().PrintMinNumber(new int[]{3, 32, 321}));
    //System.out.println("321".compareTo("413"));
  }
}
