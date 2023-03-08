import java.util.LinkedList;
import java.util.Queue;

/**
 * Leetcode problem #543, Diameter of Binary Tree
 * https://leetcode.com/problems/diameter-of-binary-tree/
 */
public class DiameterOfBinaryTree {
    private int diameter;

    public static void main(String[] args) {
        DiameterOfBinaryTree dBinaryTree = new DiameterOfBinaryTree();
        TreeNode root = dBinaryTree.createBinaryTree(new int[] { 1, 2, 3, 4, 5 });
        System.out.println(dBinaryTree.diameterOfBinaryTree(root));
    }

    public TreeNode createBinaryTree(int[] nums) {
        TreeNode root = new TreeNode(nums[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (i < nums.length) {
            TreeNode node = queue.poll();
            node.left = new TreeNode(nums[i++]);

            if (i == nums.length)
                break;
            node.right = new TreeNode(nums[i++]);

            queue.add(node.left);
            queue.add(node.right);
        }

        return root;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        traverse(root);
        return diameter;
    }

    public int traverse(TreeNode root) {
        if (root == null)
            return 0;

        int left = traverse(root.left);
        int right = traverse(root.right);

        diameter = Math.max(diameter, left + right);
        return Math.max(left, right) + 1;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
