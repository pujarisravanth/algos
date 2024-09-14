import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Leetcode problem #47, Permutations II
 * https://leetcode.com/problems/permutations-ii/
 */
public class Permutations2 {
    public static void main(String[] args) {
        int[] nums = new int[] { 1, 1, 2, 2 };
        var res = permuteUnique(nums);
        System.out.println(res);
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();

        ArrayList<Integer> numList = new ArrayList<>();
        for (int i : nums) {
            numList.add(i);
        }
        backtrack(0, nums.length, numList, res);

        return res;
    }

    public static void backtrack(int i, int n, ArrayList<Integer> nums, List<List<Integer>> res) {
        if (i == n) {
            res.add(new ArrayList<>(nums));
            return;
        }

        HashSet<Integer> set = new HashSet<>();

        for (int j = i; j < n; j++) {
            if (set.contains(nums.get(j)))
                continue;

            set.add(nums.get(j));
            Collections.swap(nums, i, j);
            backtrack(i + 1, n, nums, res);
            Collections.swap(nums, i, j);
        }
    }
}
