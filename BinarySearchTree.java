public class BinarySearchTree {

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

class Node {
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