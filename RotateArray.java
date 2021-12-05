import java.util.Arrays;

/**
 * Rotate array in clockwise direction
 * intput: [1,2,3,4,5,6,7,8]
 * output: [4,5,6,7,8,1,2,3]
 */

public class RotateArray {
    
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};
        int k = 3;

        rotateArray(arr, k);
        System.out.println(Arrays.toString(arr));
    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static void rotateArray(int arr[], int k) {
        int gcd = gcd(arr.length, k);
        for (int i = 0; i < gcd; i++) {
            int temp = arr[i];
            int j = i;
            while (true) {
                int next = (j + k) % arr.length;
                if (next == i) break;
                arr[j] = arr[next];
                j = next;
            }
            arr[j] = temp;
        }
    }
}
