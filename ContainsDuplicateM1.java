import java.util.HashSet;

/**
 * Leetcode problem #217, Contains Duplicate
 * https://leetcode.com/problems/contains-duplicate/
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class ContainsDuplicateM1 {
    public static void main(String[] args) {
        int[] nums = new int[] { 1, 2, 3, 1 };
        System.out.println(containsDuplicate(nums));
    }

    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num))
                return true;
            set.add(num);
        }

        return false;
    }
}
