package me.zabelin.mergetwosortedlists;


/*
21. Merge Two Sorted Lists https://leetcode.com/problems/merge-two-sorted-lists/description/

You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

my - O(n)
 */
public class Main {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        ListNode n1 = null;
        var n2 =  new ListNode(1, new ListNode(3, new ListNode(4, new ListNode(5))));

        var res = mergeTwoLists(n1, n2);
        do {
            System.out.println(res.val);
            res = res.next;
        } while (res != null);
    }

    static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        var curNode1 = list1;
        var curNode2 = list2;
        ListNode initResNode = null, curResNode = null;
        if (curNode1 != null && curNode2 != null && curNode1.val <= curNode2.val) {
            curResNode = curNode1;
            initResNode = curResNode;
            curNode1 = curNode1.next;
        } else if (curNode1 != null && curNode2 != null) {
            curResNode = curNode2;
            initResNode = curResNode;
            curNode2 = curNode2.next;
        } else if (curNode1 != null) {
            curResNode = curNode1;
            initResNode = curResNode;
            curNode1 = curNode1.next;
        } else if (curNode2 != null) {
            curResNode = curNode2;
            initResNode = curResNode;
            curNode2 = curNode2.next;
        }

        while (curNode1 != null && curNode2 != null) {
            var oldNode = curResNode;
            if (curNode1.val <= curNode2.val) {
                curResNode = curNode1;
                curNode1 = curNode1.next;
                oldNode.next = curResNode;
            } else {
                curResNode = curNode2;
                curNode2 = curNode2.next;
                oldNode.next = curResNode;
            }
        }

        while (curNode1 != null) {
            var oldNode = curResNode;
            curResNode = curNode1;
            curNode1 = curNode1.next;
            oldNode.next = curResNode;
        }

        while (curNode2 != null) {
            var oldNode = curResNode;
            curResNode = curNode2;
            curNode2 = curNode2.next;
            oldNode.next = curResNode;
        }

        return initResNode;
    }
}
