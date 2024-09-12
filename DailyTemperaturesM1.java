import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Leetcode problem #739, Daily Temperatures
 * https://leetcode.com/problems/daily-temperatures/
 * Basically a Next Greater Integer problem
 */
public class DailyTemperaturesM1 {
    public static void main(String[] args) {
        int[] temperatures = new int[] { 73, 74, 75, 71, 69, 72, 76, 73 };
        int[] res = dailyTemperatures(temperatures);
        System.out.println(Arrays.toString(res));
    }

    static int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];

        // Using ArrayDequeu as stack, becuase in java, they are much faster
        // This fastness majorly comes because of threadsafe implementation of stack
        Deque<Integer> st = new ArrayDeque<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!st.isEmpty() && temperatures[st.peekFirst()] < temperatures[i]) {
                int j = st.pop();
                res[j] = i - j;
            }
            st.push(i);
        }

        return res;
    }
}
