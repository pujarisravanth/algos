import java.util.HashMap;

/**
 * Leetcode problem #1679, Max Number of K-Sum Pairs
 * https://leetcode.com/problems/max-number-of-k-sum-pairs/
 * Using Hashmap, with one pass
 */
public class MaxNumberOfKSumPairsM1 {
    public static void main(String[] args) {
        int[] nums = new int[] { 3, 1, 3, 4, 3, 2 };
        int k = 6;
        System.out.println(maxOperations(nums, k));
    }

    static int maxOperations(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int cnt = 0;
        for (int n : nums) {
            int r = k - n;
            if (r > 0 && map.containsKey(r) && map.get(r) > 0) {
                cnt++;
                map.put(r, map.get(r) - 1);
            } else {
                map.put(n, map.getOrDefault(n, 0) + 1);
            }
        }

        return cnt;
    }
}
