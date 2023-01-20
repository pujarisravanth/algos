import java.util.HashSet;

/**
 * Leet code problem #217. Contains Duplicate
 * https://leetcode.com/problems/contains-duplicate/
 *
 * Given an array of integers, find if the array contains any duplicates.
 */

public class ContainsDuplicate {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 1 };
        System.out.println(containsDuplicate(arr));
    }

    // Using set (hashSet) to find whether it already exists
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
}
