import java.util.Arrays;
import java.util.HashMap;

/**
 * Leetcode problem #2352, Equal Row and Column Pairs
 * https://leetcode.com/problems/equal-row-and-column-pairs/description
 * Using Hashmap
 */
public class EqualRowAndColumnPairsM1 {
    public static void main(String[] args) {
        int[][] grid = new int[][] { { 3, 1, 2, 2 }, { 1, 4, 4, 5 }, { 2, 4, 2, 2 }, { 2, 4, 2, 2 } };
        System.out.println(equalPairs(grid));
    }

    static int equalPairs(int[][] grid) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            String key = Arrays.toString(grid[i]);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            int[] colArray = new int[grid.length];
            for (int r = 0; r < grid.length; r++) {
                colArray[r] = grid[r][i];
            }
            count += map.getOrDefault(Arrays.toString(colArray), 0);
        }

        return count;
    }
}
