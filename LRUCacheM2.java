import java.util.HashMap;

public class LRUCacheM2 {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }

    static class LRUCache {

        class DLNode {
            int key;
            int value;
            DLNode next;
            DLNode prev;

            DLNode() {
            }

            DLNode(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        private void addNode(DLNode node) {
            node.prev = head;
            node.next = head.next;

            head.next.prev = node;
            head.next = node;
        }

        private void removeNode(DLNode node) {
            node.next.prev = node.prev;
            node.prev.next = node.next;
        }

        private void moveToHead(DLNode node) {
            this.removeNode(node);
            this.addNode(node);
        }

        private DLNode popTail() {
            DLNode node = tail.prev;
            this.removeNode(node);
            return node;
        }

        private HashMap<Integer, DLNode> cache = new HashMap<>();
        private int size;
        private int capacity;
        private DLNode head, tail;

        public LRUCache(int capacity) {
            this.size = 0;
            this.capacity = capacity;

            head = new DLNode();
            tail = new DLNode();

            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            DLNode node = cache.get(key);
            if (node == null) {
                return -1;
            }

            this.moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            DLNode node = cache.get(key);
            if (node != null) {
                node.value = value;
                this.moveToHead(node);
            } else {
                DLNode newNode = new DLNode(key, value);
                this.addNode(newNode);
                cache.put(key, newNode);
                this.size++;

                if (this.size > this.capacity) {
                    DLNode tailNode = this.popTail();
                    cache.remove(tailNode.key);
                    this.size--;
                }
            }
        }
    }
}