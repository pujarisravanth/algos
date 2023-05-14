/**
 * Leet code problem #200, Number of islands
 * https://leetcode.com/problems/number-of-islands/description/
 * Using Depth First Search
 */
public class NumberOfIslandsM1 {
    public static void main(String[] args) {
        char[][] grid = {
                { '1', '1', '1', '0', '1' },
                { '1', '1', '0', '0', '1' },
                { '1', '1', '0', '0', '0' },
                { '1', '0', '0', '1', '1' },
                { '0', '0', '1', '1', '1' },
        };

        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        if (grid.length == 0)
            return 0;

        int islands = 0;
        int nr = grid.length, nc = grid[0].length;
        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    islands++;
                }
            }
        }

        return islands;
    }

    public static void dfs(char[][] grid, int i, int j) {
        int nr = grid.length, nc = grid[0].length;

        if (i < 0 || j < 0 || i >= nr || j >= nc || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
    }
}
