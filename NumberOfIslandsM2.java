import java.util.LinkedList;
import java.util.Queue;

/**
 * Leet code problem #200, Number of islands
 * https://leetcode.com/problems/number-of-islands/description/
 * Using Breadth First Search
 */
public class NumberOfIslandsM2 {
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
                    bfs(grid, i, j);
                    islands++;
                }
            }
        }

        return islands;
    }

    public static void bfs(char[][] grid, int i, int j) {
        int nr = grid.length, nc = grid[0].length;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(i, j));

        while (!queue.isEmpty()) {
            Pair p = queue.remove();
            if (p.r < 0 || p.c < 0 || p.r >= nr || p.c >= nc || grid[p.r][p.c] == '0')
                continue;

            grid[p.r][p.c] = '0';

            queue.add(new Pair(p.r, p.c + 1));
            queue.add(new Pair(p.r + 1, p.c));
            queue.add(new Pair(p.r, p.c - 1));
            queue.add(new Pair(p.r - 1, p.c));
        }
    }
}

class Pair {
    public int r;
    public int c;

    public Pair(int r, int c) {
        this.r = r;
        this.c = c;
    }
}
