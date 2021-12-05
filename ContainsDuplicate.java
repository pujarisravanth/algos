import java.util.HashSet;

/**
 * Leet code problem #217. Contains Duplicate
 * https://leetcode.com/problems/contains-duplicate/
 * 
 * Given an array of integers, find if the array contains any duplicates.
 */

public class ContainsDuplicate {
    
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 1};
        System.out.println(containsDuplicate(arr));
    }

    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
}
