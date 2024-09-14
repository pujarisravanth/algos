import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode problem #229, Majority Element II
 * https://leetcode.com/problems/majority-element-ii/
 * Given: Majority element occurs more than [ n / 3 ] times
 */
public class MajorityElements2 {

    public static void main(String[] args) {
        int[] arr = { 1, 1, 1, 3, 3, 1, 2, 2, 2, 2 };
        System.out.println(majorityElement(arr));
    }

    public static List<Integer> majorityElement(int[] nums) {
        int first = 0, second = 0;
        int firstCount = 0, secondCount = 0;

        for (int num : nums) {
            if (num == first)
                firstCount++;
            else if (num == second)
                secondCount++;
            else if (firstCount == 0) {
                first = num;
                firstCount++;
            } else if (secondCount == 0) {
                second = num;
                secondCount++;
            } else {
                firstCount--;
                secondCount--;
            }
        }

        firstCount = 0;
        secondCount = 0;
        for (int num : nums) {
            if (num == first)
                firstCount++;
            else if (num == second)
                secondCount++;
        }

        List<Integer> res = new ArrayList<>();
        if (firstCount > nums.length / 3)
            res.add(first);
        if (secondCount > nums.length / 3)
            res.add(second);

        return res;
    }
}
