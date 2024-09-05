/**
 * Leetcode problem #19, Remove nth Node From End of List
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNthLastNode {
    public static void main(String[] args) {
        ListNode list = ListNode.prepareList(new int[] { 1, 2, 3, 4, 5 });
        ListNode resList = removeNthFromEnd(list, 2);
        printList(resList);
    }

    static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode leftNode = dummy;
        ListNode rightNode = dummy;

        for (int i = 0; i <= n; i++) {
            rightNode = rightNode.next;
        }

        while (rightNode != null) {
            rightNode = rightNode.next;
            leftNode = leftNode.next;
        }

        leftNode.next = leftNode.next.next;

        return dummy.next;
    }

    static void printList(ListNode head) {
        ListNode currNode = head;
        while (currNode != null) {
            System.out.printf("%d ", currNode.val);
            currNode = currNode.next;
        }
        System.out.println();
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        static ListNode prepareList(int[] arr) {
            ListNode currNode = new ListNode();
            ListNode head = currNode;

            for (int i : arr) {
                currNode.next = new ListNode(i);
                currNode = currNode.next;
            }

            return head.next;
        }
    }

}
