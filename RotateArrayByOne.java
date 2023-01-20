/**
 * Rotate an array by one place, should be inplace
 * ex: {1, 2, 3, 4} -> {4, 1, 2, 3}
 */

import java.util.Arrays;

public class RotateArrayByOne {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        
        rotateArrayByOne(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void rotateArrayByOne(int[] arr) {
        int temp = arr[arr.length - 1];
        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = temp;
    }
}
