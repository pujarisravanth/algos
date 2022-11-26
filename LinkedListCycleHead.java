/**
 * Leetcode problem #142, Linked List Cycle II
 * https://leetcode.com/problems/linked-list-cycle-ii
 */
public class LinkedListCycleHead {
    public static void main(String[] args) {
        ListNode list = prepareList(new int[] {3, 2, 0, -4});
        createLoopAtPosition(list, 1);
        ListNode cycleHead = detectCycle(list);
        printCycleHeadPosition(list, cycleHead);
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

    public static void createLoopAtPosition(ListNode head, int pos) {
        ListNode loopHead = null;
        while (head.next != null) {
            if (pos == 0) {
                loopHead = head;
            }
            pos--;
            head = head.next;
        }
        head.next = loopHead;
    }

    public static void printCycleHeadPosition(ListNode head, ListNode cycleHead) {
        if (cycleHead == null) {
            System.out.println("no cycle");
            return;
        }

        int pos = 0;
        while (head != null) {
            if (head == cycleHead) {
                System.out.printf("tail connects to node index %d\n", pos);
                break;
            }
            pos++;
            head = head.next;
        }
    }

    public static ListNode detectCycle(ListNode head) {
        ListNode fasrPtr = head, slowPtr = head;
        while (fasrPtr != null && fasrPtr.next != null) {
            fasrPtr = fasrPtr.next.next;
            slowPtr = slowPtr.next;
            if (fasrPtr == slowPtr) break;
        }

        if (fasrPtr == null || fasrPtr.next == null) return null;

        ListNode ptr1 = slowPtr; // Also known as intersect;
        ListNode ptr2 = head;

        // Cycle head is place where these two meets
        while (ptr1 != ptr2) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        return ptr1;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) {this.val = val;}
    ListNode(int val, ListNode next) {this.val = val; this.next = next;}
}
