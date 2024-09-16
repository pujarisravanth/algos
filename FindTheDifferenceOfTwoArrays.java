import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Leetcode problem #2215, Find the difference of Two Arrays
 * https://leetcode.com/problems/find-the-difference-of-two-arrays/
 */
public class FindTheDifferenceOfTwoArrays {
    public static void main(String[] args) {
        int[] nums1 = new int[] { 1, 2, 3, 3 };
        int[] nums2 = new int[] { 1, 1, 2, 2 };
        List<List<Integer>> res = findDifference(nums1, nums2);
        System.out.println(res);
    }

    static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        for (int n : nums1) {
            set1.add(n);
        }

        List<Integer> list2 = new ArrayList<>();

        HashSet<Integer> set2 = new HashSet<>();
        for (int n : nums2) {
            if (!set2.contains(n)) {
                if (set1.contains(n)) {
                    set1.remove(n);
                } else {
                    list2.add(n);
                }
                set2.add(n);
            }
        }

        return List.of(new ArrayList<>(set1), list2);
    }
}
