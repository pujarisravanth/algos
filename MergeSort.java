import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] nums = { 5, 1, 1, 2, 0, 0 };
        int[] res = sortArray(nums);
        System.out.println(Arrays.toString(res));
    }

    public static int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    public static void mergeSort(int[] nums, int l, int r) {
        if (l >= r)
            return;

        int m = (r + l) / 2;
        mergeSort(nums, l, m);
        mergeSort(nums, m + 1, r);

        merge(nums, l, r, m);
    }

    public static void merge(int[] nums, int l, int r, int m) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] lArr = new int[n1];
        int[] rArr = new int[n2];

        for (int i = 0; i < n1; i++) {
            lArr[i] = nums[i + l];
        }

        for (int i = 0; i < n2; i++) {
            rArr[i] = nums[i + m + 1];
        }

        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            nums[k++] = (lArr[i] <= rArr[j]) ? lArr[i++] : rArr[j++];
        }

        while (i < n1) {
            nums[k++] = lArr[i++];
        }

        while (j < n2) {
            nums[k++] = rArr[j++];
        }
    }
}
