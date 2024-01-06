import java.util.HashSet;
import java.util.Set;

/**
 * Leetcode problem #219, Contains Duplicate II
 * https://leetcode.com/problems/contains-duplicate-ii/
 * 
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class ContainsDuplicateM2 {
    public static void main(String[] args) {
        int[] nums = new int[] { 1, 2, 3, 1 };
        int k = 3;
        System.out.println(containsNearbyDuplicate(nums, k));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i]))
                return true;
            set.add(nums[i]);
            if (set.size() > k)
                set.remove(nums[i - k]);
        }

        return false;
    }
}
