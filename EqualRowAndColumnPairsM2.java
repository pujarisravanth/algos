import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode problem #2352, Equal Row and Column Pairs
 * https://leetcode.com/problems/equal-row-and-column-pairs/description
 * Using Trie Data Structure
 */
public class EqualRowAndColumnPairsM2 {
    public static void main(String[] args) {
        int[][] grid = new int[][] { { 3, 1, 2, 2 }, { 1, 4, 4, 5 }, { 2, 4, 2, 2 }, { 2, 4, 2, 2 } };
        System.out.println(equalPairs(grid));
    }

    static int equalPairs(int[][] grid) {
        Trie trie = new Trie();

        for (int[] row : grid) {
            trie.insert(row);
        }

        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            int[] col = new int[grid.length];
            for (int j = 0; j < grid.length; j++) {
                col[j] = grid[j][i];
            }
            count += trie.search(col);
        }

        return count;
    }

    static class TrieNode {
        int count;
        Map<Integer, TrieNode> child;

        TrieNode() {
            count = 0;
            child = new HashMap<>();
        }
    }

    static class Trie {
        TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        void insert(int[] nums) {
            TrieNode node = root;
            for (int i : nums) {
                if (!node.child.containsKey(i)) {
                    node.child.put(i, new TrieNode());
                }
                node = node.child.get(i);
            }
            node.count += 1;
        }

        int search(int[] nums) {
            TrieNode node = root;
            for (int i : nums) {
                if (!node.child.containsKey(i)) {
                    return 0;
                }
                node = node.child.get(i);
            }
            return node.count;
        }
    }
}
