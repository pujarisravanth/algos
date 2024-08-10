import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Leetcode #15, 3Sum
 * https://leetcode.com/problems/3sum/
 * Without the use of sort, using hash maps
 */
public class ThreeSumM2 {
    public static void main(String[] args) {
        int[] nums = { -1, 0, 1, 2, -1, -4 };
        List<List<Integer>> res = threeSum(nums);

        System.out.println(res.toString());
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> res = new HashSet<>();
        HashSet<Integer> dup = new HashSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            // If the already taken as base element, do process that
            if (dup.add(nums[i])) {
                for (int j = i + 1; j < nums.length; j++) {
                    int compliment = -nums[i] - nums[j];

                    // If the map contains the compliment and the compliment is added only while
                    // this base element
                    if (map.containsKey(compliment) && map.get(compliment) == i) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], compliment);
                        Collections.sort(triplet);
                        res.add(triplet);
                    }

                    // This tells us that this element added in this traverse (of base i)
                    map.put(nums[j], i);
                }
            }
        }

        return new ArrayList<>(res);
    }
}
