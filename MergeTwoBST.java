import java.util.ArrayList;
import java.util.List;

import apple.laf.JRSUIUtils.Tree;

/**
 * Leet code problem, #1305: All Elements in Two Binary Search Trees
 * https://leetcode.com/problems/all-elements-in-two-binary-search-trees/
 */

public class MergeTwoBST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int x, TreeNode left, TreeNode right) {
            this.val = x;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {

    }

    public static List<Integer> getAllElelments(TreeNode root1, TreeNode root2) {
        List<Integer> res = new ArrayList<>();

        return res;
    }

    public static void storeInOrderTraversal(TreeNode node, List res) {

    }
}
