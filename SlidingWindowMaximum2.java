import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * Leetcode problem #239, Sliding Window Maximum
 * https://leetcode.com/problems/sliding-window-maximum/
 * Using double ended linkedlist (deque), time complexity will be O(n)
 */
public class SlidingWindowMaximum2 {
    public static void main(String[] args) {
        int[] nums = { 1, 3, -1, -3, -5, 5, 3, 6, 7 };
        int[] res = maxSlidingWindow(nums, 3);
        System.out.println(Arrays.toString(res));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        ArrayDeque<Pair> deq = new ArrayDeque<>();

        for (int i = 0; i < k - 1; i++) {
            addElement(deq, new Pair(nums[i], i));
        }

        // Starting from the last element which belongs to the window
        // Or we can say starting the windows
        for (int i = k - 1; i < nums.length; i++) {

            // Removinf any element to the left if it is outside window
            // Mostly, may be only one will be there, just for safety
            while (deq.size() > 0 && deq.peekFirst().index < i - k + 1) {
                deq.removeFirst();
            }

            addElement(deq, new Pair(nums[i], i));
            res[i - k + 1] = deq.getFirst().value;
        }

        return res;
    }

    // We store the deq, such that the values are in decreasing order
    public static void addElement(ArrayDeque<Pair> deq, Pair p) {
        while (deq.size() > 0 && deq.getLast().value < p.value) {
            deq.removeLast();
        }
        deq.addLast(p);
    }

    static class Pair {
        int value;
        int index;

        Pair(int val, int i) {
            this.value = val;
            this.index = i;
        }
    }
}