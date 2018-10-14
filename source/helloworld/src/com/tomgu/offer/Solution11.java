package com.tomgu.offer;

/**
 * Created by guzuxing on 2018/10/10.
 */
public class Solution11 {

  public ListNode FindKthToTail(ListNode head, int k) {
    if (head == null) {
      return head;
    }
    if (k == 0) {
      return null;
    }
    ListNode p = head;
    ListNode target = head;
    for (int i = 2; i <= k; i++) {
      if (p.next == null) {
        return null;
      }
      p = p.next;
    }
    while (p.next != null) {
      p = p.next;
      target = target.next;
    }
    return target;
  }

}
