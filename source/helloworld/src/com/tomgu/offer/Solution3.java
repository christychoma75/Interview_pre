package com.tomgu.offer;

import java.util.ArrayList;
import java.util.Collections;

public class Solution3 {

  public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
    ArrayList<Integer> result = new ArrayList<>();
    if (listNode == null) {
      return result;
    }

    if (listNode.next == null) {
      result.add(listNode.val);
      return result;
    }

    ListNode p = listNode;
    while (p != null) {
      result.add(p.val);
      p = p.next;
    }
    Collections.reverse(result);
    return result;
  }

  public static void main(String[] arg) {
    ListNode n1 = new ListNode(1);
    ListNode n2 = new ListNode(2);
    ListNode n3 = new ListNode(3);
    ListNode n4 = new ListNode(4);
    n1.next = n2;
    n2.next = n3;
    n3.next = n4;
    ArrayList<Integer> r = new Solution3().printListFromTailToHead(n1);
    r.stream().forEach(x -> System.out.println(x));

  }
}


class ListNode {

  int val;
  ListNode next = null;

  ListNode(int val) {
    this.val = val;
  }
}