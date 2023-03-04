import java.util.PriorityQueue;

/**
 * Leetcode problem #23, Merge k Sorted Lists
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * Using min heap soultion, time complexity O(n), space complexity O(k)
 */
public class MergeSortedlists {
    public static void main(String[] args) {
        ListNode[] lists = {
                createList(new int[] { 1, 4, 5 }),
                createList(new int[] { 1, 3, 4 }),
                createList(new int[] { 2, 6 })
        };

        ListNode node = mergeKLists(lists);

        while (node != null) {
            System.out.printf("%d ", node.val);
            node = node.next;
        }
        System.out.println();
    }

    public static ListNode createList(int[] nums) {
        ListNode head = new ListNode();
        ListNode ptr = head;

        for (int num : nums) {
            ptr.next = new ListNode(num);
            ptr = ptr.next;
        }

        return head.next;
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        ListNode head = new ListNode(), curNode = head;

        for (ListNode list : lists) {
            if (list == null)
                continue;
            minHeap.add(list);
        }

        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            if (node.next != null)
                minHeap.add(node.next);
            curNode.next = node;
            curNode = curNode.next;
        }

        return head.next;
    }
}

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
}
