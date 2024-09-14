/**
 * Leetcode problem #21, Merge Two Sorted Lists
 * https://leetcode.com/problems/merge-two-sorted-lists
 */
public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode list1 = prepareList(new int[] { 1, 2, 4 });
        ListNode list2 = prepareList(new int[] { 1, 3, 4 });

        ListNode resList = mergeTwoLists(list1, list2);
        printList(resList);
    }

    public static ListNode prepareList(int[] arr) {
        ListNode currNode = new ListNode();
        ListNode head = currNode;
        for (int i : arr) {
            currNode.next = new ListNode(i);
            currNode = currNode.next;
        }
        return head.next;
    }

    public static void printList(ListNode list) {
        while (list != null) {
            System.out.print(list.val);
            System.out.print(" ");
            list = list.next;
        }
        System.out.println();
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode currNode = new ListNode();
        ListNode head = currNode;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                currNode.next = list1;
                list1 = list1.next;
            } else {
                currNode.next = list2;
                list2 = list2.next;
            }

            currNode = currNode.next;
        }

        if (list1 != null) {
            currNode.next = list1;
        }
        if (list2 != null) {
            currNode.next = list2;
        }

        return head.next;
    }

    static class ListNode {
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
}