package com.tomgu.offer;

/**
 * Created by guzuxing on 2018/10/10.
 */

public class Solution16 {

  public ListNode Merge(ListNode list1, ListNode list2) {
    if (list1 == null) {
      return list2;
    }
    if (list2 == null) {
      return list1;
    }
    ListNode result;

    if (list1.val < list2.val) {
      result = list1;
      list1 = list1.next;
    } else {
      result = list2;
      list2 = list2.next;
    }
    ListNode head = result;
    while (list1 != null && list2 != null) {
      if (list1.val < list2.val) {
        result.next = list1;
        list1 = list1.next;
      } else {
        result.next = list2;
        list2 = list2.next;
      }
      result = result.next;
    }
    while (list1 != null) {
      result.next = list1;
      list1 = list1.next;
      result = result.next;
    }
    while (list2 != null) {
      result.next = list2;
      list2 = list2.next;
      result = result.next;
    }
    return head;
  }

  public static void main(String[] args) {
    ListNode n1 = new ListNode(1);
    ListNode n2 = new ListNode(2);
    ListNode n3 = new ListNode(3);
    ListNode n4 = new ListNode(4);
    ListNode n5 = new ListNode(5);
    ListNode n6 = new ListNode(6);
    n1.next = n3;
    n3.next = n5;
    n2.next = n4;
    n4.next = n6;
    ListNode r = new Solution16().Merge(n1, n2);
    System.out.println(r);
  }
}