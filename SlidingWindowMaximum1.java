import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Leetcode problem #239, Sliding Window Maximum
 * https://leetcode.com/problems/sliding-window-maximum/
 * Using max heap solution of time complexity O(nlogn)
 */
public class SlidingWindowMaximum1 {
    public static void main(String[] args) {
        int[] nums = { 1, 3, -1, -3, -5, 5, 3, 6, 7 };
        int[] res = maxSlidingWindow(nums, 3);
        System.out.println(Arrays.toString(res));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> b.value - a.value);

        for (int i = 0; i < k - 1; i++) {
            maxHeap.add(new Pair(nums[i], i));
        }

        for (int i = k - 1; i < nums.length; i++) {
            while (maxHeap.size() > 0 && maxHeap.peek().index < i - k + 1) {
                maxHeap.poll();
            }
            maxHeap.add(new Pair(nums[i], i));
            res[i - k + 1] = maxHeap.peek().value;
        }

        return res;
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