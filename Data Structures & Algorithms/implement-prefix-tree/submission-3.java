class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEnd = false;
}

class PrefixTree {
    TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode curr = root;

        for (char c : word.toCharArray()) {
            int idx = c - 'a';

            if (curr.children[idx] == null) {
                curr.children[idx] = new TrieNode();
            }

            curr = curr.children[idx];
        }

        curr.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode node = find(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return find(prefix) != null;
    }

    private TrieNode find(String str) {
        TrieNode curr = root;

        for (char c : str.toCharArray()) {
            int idx = c - 'a';

            if (curr.children[idx] == null) {
                return null;
            }

            curr = curr.children[idx];
        }

        return curr;
    }
}