import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Leetcode problem #46, Permutations
 * https://leetcode.com/problems/permutations/
 */
public class Permutations {
    public static void main(String[] args) {
        int[] nums = new int[] { 1, 2, 3 };
        var permutations = permute(nums);
        System.out.println(permutations);
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();

        List<Integer> numList = new ArrayList<>();
        for (int i : nums) {
            numList.add(i);
        }

        backtrack(0, nums.length, numList, res);

        return res;
    }

    public static void backtrack(int i, int n, List<Integer> nums, List<List<Integer>> res) {
        if (i == n) {
            res.add(new ArrayList<>(nums));
            return;
        }

        for (int j = i; j < n; j++) {
            Collections.swap(nums, i, j);
            backtrack(i + 1, n, nums, res);
            Collections.swap(nums, i, j);
        }
    }
}
