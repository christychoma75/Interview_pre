package com.tomgu.offer;


import java.util.HashMap;
import java.util.Map;

class RandomListNode {

  int label;
  RandomListNode next = null;
  RandomListNode random = null;

  RandomListNode(int label) {
    this.label = label;
  }
}

public class Solution36 {

  Map<RandomListNode, RandomListNode> nodeMap = new HashMap<>();

  public RandomListNode Clone(RandomListNode pHead) {
    if (pHead == null) {
      return null;
    }
    RandomListNode head = new RandomListNode(pHead.label);

    nodeMap.put(pHead, head);

    // build next
    RandomListNode itrHead = head;
    RandomListNode itrPHead = pHead;
    while (itrPHead.next != null) {
      RandomListNode newNode = new RandomListNode(itrPHead.next.label);
      itrHead.next = newNode;
      itrHead = newNode;
      itrPHead = itrPHead.next;
      // update map
      nodeMap.put(itrPHead, itrHead);
    }

    // build random
    itrHead = head;
    itrPHead = pHead;
    RandomListNode tem;
    if (itrPHead.random == null) {
      itrHead.random = null;
    } else {
      tem = nodeMap.get(itrPHead.random);
      itrHead.random = tem;
    }
    while (itrPHead.next != null) {
      itrPHead = itrPHead.next;
      itrHead = itrHead.next;
      if (itrPHead.random == null) {
        itrHead.random = null;
      } else {
        tem = nodeMap.get(itrPHead.random);
        itrHead.random = tem;
      }
    }

    return head;
  }

  public static void main(String[] arg) {
    RandomListNode r1 = new RandomListNode(1);
    RandomListNode r2 = new RandomListNode(2);
    RandomListNode r3 = new RandomListNode(3);
    RandomListNode r4 = new RandomListNode(4);
    RandomListNode r5 = new RandomListNode(5);
    r1.next = r2;
    r2.next = r3;
    r3.next = r4;
    r4.next = r5;
    r1.random = r3;
    r2.random = r5;
    r4.random = r2;
    RandomListNode head = new Solution36().Clone(r1);
    System.out.println(head.label);
  }
}
