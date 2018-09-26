package com.tomgu.leetcode.No206;

public class Solution206 {

  public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode pre = null;
    ListNode c = head;
    ListNode n = head.next;
    ListNode tem = null;
    while (n.next != null) {
      tem = n.next;
      c.next = pre;
      n.next = c;
      pre = c;
      c = n;
      n = tem;
    }
    c.next = pre;
    n.next = c;
    return n;
  }
}
