public class SingleElementInSortedArray {
    public static void main(String[] args) {
        int[] nums = { 1, 1, 2, 3, 3, 4, 4, 8, 8 };
        int value = singleNonDuplicate(nums);
        System.out.println(value);
    }

    public static int singleNonDuplicate(int[] nums) {
        int l = 0, r = nums.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (mid % 2 == 1)
                mid--;
            if (nums[mid] == nums[mid + 1]) {
                l = mid + 2;
            } else {
                r = mid;
            }
        }

        return nums[l];
    }
}
