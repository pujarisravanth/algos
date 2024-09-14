/**
 * Leet code problem #169, Majority Element
 * https://leetcode.com/problems/majority-element/
 * Given: Majority element occurs more than half of the time
 * Using Boyer-Moore majority voting algorithm
 */
public class MajorityElement {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 2, 2, 2, 5, 4, 2 };
        System.out.println(majorityElement(arr));
    }

    public static int majorityElement(int[] nums) {
        int votes = 0;
        int res = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (votes == 0) {
                res = nums[i];
            }
            if (res == nums[i])
                votes++;
            else
                votes--;
        }

        return res;
    }
}
