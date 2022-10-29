/**
 * Leetcode problem #2, Add Two Numbers
 * https://leetcode.com/problems/add-two-numbers/
 */

class ListNode {
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

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        ListNode node = this;
        while (node != null) {
            str.append(String.valueOf(node.val));
            node = node.next;
        }
        return str.toString();
    }
}

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = createList(new int[] { 9, 9, 9, 9, 9, 9, 9 });
        ListNode l2 = createList(new int[] { 9, 9, 9, 9 });

        ListNode res = addTwoNumbers(l1, l2);
        System.out.println(res);
    }

    public static ListNode createList(int[] nums) {
        ListNode head = new ListNode();
        ListNode currNode = head;
        for (int i = 0; i < nums.length; i++) {
            currNode.next = new ListNode(nums[i]);
            currNode = currNode.next;
        }
        return head.next;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode currNode = head;
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
            currNode.next = new ListNode(sum % 10);
            currNode = currNode.next;
        }

        if (carry > 0) {
            currNode.next = new ListNode(carry);
        }

        return head.next;
    }
}
