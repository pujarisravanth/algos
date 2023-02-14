import java.util.Arrays;

public class WiggleSort {
    public static void main(String[] args) {
        int[] nums = { 3, 5, 2, 1, 6, 4 };
        wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void wiggleSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if ((i % 2 == 1 && nums[i] < nums[i - 1]) || (i % 2 == 0 && nums[i] > nums[i - 1])) {
                swap(nums, i, i - 1);
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
