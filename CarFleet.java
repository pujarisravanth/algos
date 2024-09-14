import java.util.Arrays;

/**
 * Leetcode problem #853, Car Fleet
 * https://leetcode.com/problems/car-fleet/
 */
public class CarFleet {
    public static void main(String[] args) {
        int target = 12;
        int[] position = new int[] { 10, 8, 0, 5, 3 };
        int[] speed = new int[] { 2, 4, 1, 1, 3 };
        System.out.println(carFleet(target, position, speed));
    }

    static int carFleet(int target, int[] position, int[] speed) {
        int res = 0;
        double max = 0;

        int[][] arr = new int[position.length][];
        for (int i = 0; i < position.length; i++) {
            arr[i] = new int[] { position[i], speed[i] };
        }

        Arrays.sort(arr, (a, b) -> b[0] - a[0]);
        for (int i = 0; i < position.length; i++) {
            double time = (target - arr[i][0]) * 1.0 / arr[i][1];
            if (time > max) {
                max = time;
                res++;
            }
        }

        return res;
    }
}