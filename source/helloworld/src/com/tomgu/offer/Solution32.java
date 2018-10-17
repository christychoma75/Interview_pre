package com.tomgu.offer;

import java.util.Stack;

public class Solution32 {

  public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
    if (pHead1 == null || pHead2 == null) {
      return null;
    }
    Stack<ListNode> S1 = new Stack<>();
    Stack<ListNode> S2 = new Stack<>();
    ListNode n1 = pHead1;
    ListNode n2 = pHead2;
    while (n1 != null) {
      S1.push(n1);
      n1 = n1.next;
    }
    while (n2 != null) {
      S2.push(n2);
      n2 = n2.next;
    }

    // check top
    n1 = S1.pop();
    n2 = S2.pop();
    ListNode result = null;
    if (n1 == n2) {
      result = n1;
    } else {
      return result;
    }

    while (!S1.isEmpty() && !S2.isEmpty()) {
      n1 = S1.pop();
      n2 = S2.pop();
      if (n1 == n2) {
        result = n1;
      } else {
        break;
      }
    }

    return result;

  }

  public static void main(String[] arg) {
    ListNode n1 = new ListNode(1);
    ListNode n2 = new ListNode(2);
    ListNode n3 = new ListNode(3);
    ListNode n4 = new ListNode(4);
    ListNode n5 = new ListNode(5);
    ListNode n6 = new ListNode(6);
    ListNode n7 = new ListNode(7);
    n1.next = n2;
    n2.next = n3;
    n4.next = n5;
    n3.next = n6;
    n6.next = n7;
    n5.next = n6;
    System.out.println(new Solution32().FindFirstCommonNode(n1, n4).val);
  }
}
