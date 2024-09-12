import java.util.Arrays;

/**
 * Leetcode problem #739, Daily Temperatures
 * https://leetcode.com/problems/daily-temperatures/
 * Without using stack/dequeue etc. any extra space other than result
 * 
 * Basically check what is the greater value for the next one, which becomes a
 * potential to this one, if not checks what is greater to that one. so on ..
 * Also, keep track of max found from right, so to avoid un-necessary looping
 */
public class DailyTemperaturesM2 {
    public static void main(String[] args) {
        int[] temperatures = new int[] { 73, 74, 75, 71, 69, 72, 76, 73 };
        int[] res = dailyTemperatures(temperatures);
        System.out.println(Arrays.toString(res));
    }

    static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        int maxTemp = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (temperatures[i] >= maxTemp) {
                maxTemp = temperatures[i];
                continue;
            }

            int days = 1;
            while (temperatures[i] >= temperatures[i + days]) {
                days += res[i + days];
            }
            res[i] = days;
        }

        return res;
    }
}
