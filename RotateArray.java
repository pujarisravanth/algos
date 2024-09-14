import java.util.Arrays;

public class RotateArray {

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int k = 3;

        rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    public static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static void rotate(int[] nums, int k) {
        int gcd = gcd(nums.length, k);
        for (int i = 0; i < gcd; i++) {
            int temp = nums[i];
            int j = i;
            while (true) {
                int next = (j + k) % nums.length;
                if (next == i)
                    break;
                nums[j] = nums[next];
                j = next;
            }
            nums[j] = temp;
        }
    }
}
