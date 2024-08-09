import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode problem #589, N-ary Tree Preorder Traversal
 * https://leetcode.com/problems/n-ary-tree-preorder-traversal
 */
public class NaryTreePreOrderTraversal {
    public static void main(String[] args) {
        Integer[] arr = new Integer[] { 1, null, 2, 3, 4, 5, null, null, 6, 7, null, 8, null, 9, 10, null, null, 11,
                null, 12, null, 13, null, null, 14 };
        Node root = createNaryTree(arr);
        List<Integer> preOrderList = preOrder(root);
        System.out.println(preOrderList);
    }

    public static Node createNaryTree(Integer[] arr) {
        Node root = new Node(arr[0]);
        addChildNodes(root, arr, 2);
        return root;
    }

    public static int addChildNodes(Node node, Integer[] arr, int i) {
        if (i >= arr.length)
            return i;

        while (i < arr.length && arr[i] != null) {
            node.children.add(new Node(arr[i]));
            i++;
        }

        for (Node child : node.children) {
            i = addChildNodes(child, arr, i + 1);
        }

        return i;
    }

    public static List<Integer> preOrder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;

        list.add(root.val);
        preOrderOfNode(root, list);
        return list;
    }

    public static void preOrderOfNode(Node node, List<Integer> list) {
        for (Node child : node.children) {
            list.add(child.val);
            preOrderOfNode(child, list);
        }
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
            this.children = new ArrayList<>();
        }

        public Node(int val) {
            this.val = val;
            this.children = new ArrayList<>();
        }

        public Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }
}