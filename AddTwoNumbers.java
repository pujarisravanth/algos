/**
 * Leet code problem #2. Add Two Numbers
 * https://leetcode.com/problems/add-two-numbers/
 * 
 * You are given two non-empty linked lists representing two non-negative
 * integers.
 * The digits are stored in reverse order and each of their nodes contain a
 * single digit.
 * Add the two numbers and return it as a linked list.
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    ListNode(int x, ListNode next) {
        val = x;
        this.next = next;
    }
}

public class AddTwoNumbers {

    public static void main(String[] args) {
        int[] nums1 = { 2, 4, 3 };
        int[] nums2 = { 5, 6, 4 };

        ListNode l1 = getListNode(nums1);
        ListNode l2 = getListNode(nums2);

        ListNode result = addTwoNumbers(l1, l2);
        printList(result);
    }

    // Creates a list node from array of numbers
    public static ListNode getListNode(int[] nums) {
        ListNode head = new ListNode(nums[0]);
        ListNode curr = head;
        for (int i = 1; i < nums.length; i++) {
            curr.next = new ListNode(nums[i]);
            curr = curr.next;
        }
        return head;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode curr = head;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
        }

        if (carry > 0) {
            curr.next = new ListNode(carry);
        }

        return head.next;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}