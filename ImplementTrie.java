public class ImplementTrie {
    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple")); // True
        System.out.println(trie.search("app")); // False
        System.out.println(trie.startsWith("app")); // True

        trie.insert("app");
        System.out.println(trie.search("app")); // True
    }

    static class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (!node.containsKey(c)) {
                    node.put(c, new TrieNode());
                }
                node = node.get(c);
            }
            node.setEnd();
        }

        public boolean search(String word) {
            TrieNode node = searchPrefix(word);
            return node != null && node.isEnd();
        }

        private TrieNode searchPrefix(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (!node.containsKey(c))
                    return null;
                node = node.get(c);
            }
            return node;
        }

        // Since we are only searching prefix, we won't consider isEnd()
        public boolean startsWith(String prefix) {
            TrieNode node = searchPrefix(prefix);
            return node != null;
        }
    }

    static class TrieNode {
        private TrieNode[] child;
        private boolean isEnd;

        public TrieNode() {
            child = new TrieNode[26];
        }

        public boolean containsKey(char ch) {
            return child[ch - 'a'] != null;
        }

        public TrieNode get(char ch) {
            return child[ch - 'a'];
        }

        public void put(char ch, TrieNode node) {
            child[ch - 'a'] = node;
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }
    }
}
