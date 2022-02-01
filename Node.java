public class Node {
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