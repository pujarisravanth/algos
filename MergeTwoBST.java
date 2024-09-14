import java.util.ArrayList;
import java.util.List;

/**
 * Leet code problem, #1305: All Elements in Two Binary Search Trees
 * https://leetcode.com/problems/all-elements-in-two-binary-search-trees/
 */
public class MergeTwoBST {

    public static void main(String[] args) {
        int arr1[] = { 1, 3, 5, 7 };
        Node root1 = BinarySearchTree.sortedArrayToBST(arr1, 0, arr1.length - 1);

        int arr2[] = { 2, 4, 6, 8, 10, 12, 14 };
        Node root2 = BinarySearchTree.sortedArrayToBST(arr2, 0, arr2.length - 1);

        List<Integer> result = getAllElelments(root1, root2);
        System.out.println(result);
    }

    public static List<Integer> getAllElelments(Node root1, Node root2) {
        List<Integer> res1 = new ArrayList<>();
        storeInOrderTraversal(root1, res1);

        List<Integer> res2 = new ArrayList<>();
        storeInOrderTraversal(root2, res2);

        return mergeTwoSortedArrays(res1, res2);
    }

    public static List<Integer> mergeTwoSortedArrays(List<Integer> res1, List<Integer> res2) {
        List<Integer> res = new ArrayList<>();

        int i = 0;
        int j = 0;
        int n1 = res1.size();
        int n2 = res2.size();

        while (i < n1 && j < n2) {
            if (res1.get(i) < res2.get(j)) {
                res.add(res1.get(i));
                i++;
            } else {
                res.add(res2.get(j));
                j++;
            }
        }

        while (i < n1) {
            res.add(res1.get(i));
            i++;
        }

        while (j < n2) {
            res.add(res2.get(j));
            j++;
        }

        return res;
    }

    public static void storeInOrderTraversal(Node node, List<Integer> res) {
        if (node == null) {
            return;
        }

        storeInOrderTraversal(node.left, res);
        res.add(node.val);
        storeInOrderTraversal(node.right, res);
    }

    static class BinarySearchTree {

        public Node root;

        public Node search(int target) {
            return search(this.root, target);
        }

        public static Node search(Node root, int target) {
            if (root == null) {
                return null;
            }

            if (root.val == target) {
                return root;
            }

            if (root.val > target) {
                return search(root.left, target);
            }

            return search(root.right, target);
        }

        public void sortedArrayToBST(int[] arr) {
            this.root = sortedArrayToBST(arr, 0, arr.length - 1);
        }

        public static Node sortedArrayToBST(int[] arr, int start, int end) {
            if (start > end) {
                return null;
            }

            int mid = start + (end - start) / 2;

            Node node = new Node(arr[mid]);
            node.left = sortedArrayToBST(arr, start, mid - 1);
            node.right = sortedArrayToBST(arr, mid + 1, end);

            return node;
        }

        public void printInorderTraversal() {
            printInorderTraversal(this.root);
        }

        public static void printInorderTraversal(Node node) {
            if (node == null) {
                return;
            }

            printInorderTraversal(node.left);
            System.out.print(node.val + " ");
            printInorderTraversal(node.right);
        }
    }

    static class Node {
        int val;
        Node left;
        Node right;

        Node() {
        }

        Node(int val) {
            this.val = val;
        }

        Node(int x, Node left, Node right) {
            this.val = x;
            this.left = left;
            this.right = right;
        }
    }
}