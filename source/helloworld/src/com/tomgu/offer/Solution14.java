package com.tomgu.offer;

/**
 * Created by guzuxing on 2018/10/10.
 */
public class Solution14 {

  /*
  public class ListNode {
      int val;
      ListNode next = null;

      ListNode(int val) {
          this.val = val;
      }
  }*/
  public class Solution {

    public ListNode ReverseList(ListNode head) {
      if (head == null) {
        return head;
      }
      if (head.next == null) {
        return head;
      }
      ListNode p, q;
      p = null;
      q = head;
      while (q.next != null) {
        ListNode tem = q.next;
        q.next = p;
        p = q;
        q = tem;
      }
      q.next = p;
      return q;
    }
  }
}
