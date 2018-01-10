package com.tomgu.leetcode.No21;

/**
 * Created by guzuxing on 10/01/2018.
 * test 21
 */
public class TestNo21 {
  public static void main(String[] args) {
    ListNode n11 = new ListNode(1);
    ListNode n12 = new ListNode(2);
    ListNode n13 = new ListNode(4);
    n11.next = n12;
    n12.next = n13;

    ListNode n21 = new ListNode(1);
    ListNode n22 = new ListNode(3);
    ListNode n23 = new ListNode(4);
    n21.next = n22;
    n22.next = n23;

    ListNode result = Solution21.mergeTwoLists(n11, n21);
    while (result != null) {
      System.out.print(result.val + "->");
      result = result.next;
    }

  }
}
