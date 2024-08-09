/**
 * Leetcode problem #206, Reverse Linked List
 * https://leetcode.com/problems/reverse-linked-list
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode list = prepareList(new int[] { 1, 2, 3, 4, 5 });
        ListNode resList = reverseList(list);
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

    public static ListNode reverseList(ListNode head) {
        ListNode prevNode = null, tempNode;
        while (head != null) {
            tempNode = head.next;
            head.next = prevNode;
            prevNode = head;
            head = tempNode;
        }

        return prevNode;
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