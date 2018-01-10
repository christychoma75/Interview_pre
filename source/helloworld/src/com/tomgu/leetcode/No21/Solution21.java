package com.tomgu.leetcode.No21;

/**
 * Created by guzuxing on 10/01/2018.
 * https://leetcode.com/problems/merge-two-sorted-lists/description/
 */
class Solution21 {
  static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode head;
    ListNode current;

    ListNode current1 = l1;
    ListNode current2 = l2;
    if (l1 == null) {
      return l2;
    }

    if (l2 == null) {
      return l1;
    }

    if (current1.val < current2.val) {
      head = new ListNode(current1.val);
      current1 = current1.next;
    } else {
      head = new ListNode(current2.val);
      current2 = current2.next;
    }

    current = head;
    ListNode n;
    while(current1 != null && current2!= null) {
      if (current1.val < current2.val) {
        n = new ListNode(current1.val);
        current1 = current1.next;
      } else {
        n = new ListNode(current2.val);
        current2 = current2.next;
      }

      current.next = n;
      current = n;
    }

    while (current1 != null) {
      n = new ListNode(current1.val);
      current.next = n;
      current = n;

      current1 = current1.next;
    }

    while (current2 != null) {
      n = new ListNode(current2.val);
      current.next = n;
      current = n;

      current2 = current2.next;
    }

    return head;
  }
}
