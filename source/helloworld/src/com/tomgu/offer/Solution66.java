package com.tomgu.offer;

public class Solution66 {

  ListNode head = null;
  int size = 0;

  public void Insert(Integer num) {
    ListNode node = new ListNode(num);
    if (head == null) {
      head = node;
      size = 1;
      return;
    }

    ListNode p = head;
    size++;
    while (p != null) {
      if (p.val < node.val) {
        if (p.next != null) {
          if (p.next.val >= node.val) {
            ListNode tem = p.next;
            p.next = node;
            node.next = tem;
            return;
          } else {
            p = p.next;
          }
        } else {
          p.next = node;
          return;
        }
      } else {
        head = node;
        node.next = p;
        return;
      }
    }

  }

  public Double GetMedian() {
    ListNode p = head;
    if (p == null) {
      return 0.0;
    }

    if (size % 2 == 1) {
      int target = size / 2;
      while (target > 0) {
        p = p.next;
        target--;
      }
      return (double) p.val;
    } else {
      int target = size / 2 - 1;
      while (target > 0) {
        target--;
        p = p.next;
      }
      double d = (double) p.val + (double) p.next.val;
      return d / 2;
    }
  }

  public static void main(String[] arg) {
    Solution66 s = new Solution66();
    s.Insert(1);
    s.Insert(2);
    s.Insert(3);
    System.out.println(s.GetMedian());
    s.Insert(4);
    System.out.println(s.GetMedian());
  }
}
