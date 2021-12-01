package com.shreyas.growth;

public class ReverseLinkedList {
    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode createListNode(int[] data) {
        ListNode curr = null;
        ListNode prev = null;
        for (int i = data.length - 1; i >= 0; i--) {
            curr = new ListNode(data[i], prev);
            prev = curr;
        }
        return curr;
    }

    public static void main(String[] args) {
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        int[] data = {1, 2, 3, 4, 5};
        ListNode listNode = reverseLinkedList.createListNode(data);
        int[] reverseData = reverseData(data);
        ListNode reverseList = reverseList(listNode);
        //Do compare
    }

    private static int[] reverseData(int[] data) {
        int[] reverseData=new int[data.length];
        for (int i = 0; i < data.length; i++) {
            reverseData[i]=data[data.length-1-i];
        }
        return reverseData;
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode curr = head;
        ListNode prev = null;
        ListNode next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
