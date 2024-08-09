/**
 * Leetcode problem #876, Middle of the Linked List
 * https://leetcode.com/problems/middle-of-the-linked-list
 */
public class MiddleOfLinkedList {
    public static void main(String[] args) {
        ListNode list = prepareList(new int[] { 1, 2, 3, 4, 5, 6 });
        ListNode midNode = middleNode(list);
        System.out.println(midNode.val);
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

    public static ListNode middleNode(ListNode head) {
        ListNode node = head;
        while (node != null && node.next != null) {
            node = node.next.next;
            head = head.next;
        }
        return head;
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