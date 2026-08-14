class Node {
    Node[] children;
    boolean isEnd;

    public Node() {
        children = new Node[26];
        isEnd = false;
    }

    public void addWord(String word, int index) {
        if (word.length() == index) {
            isEnd = true;
            return;
        }

        char c = word.charAt(index);
        children[c - 'a'] = children[c - 'a'] == null ? new Node() : children[c - 'a'];
        Node next = children[c - 'a'];

        next.addWord(word, index + 1);
    }

    public boolean search(String word, int index) {
        if (index == word.length()) return isEnd;
        char c = word.charAt(index);

        // System.out.print("hi:" + c + '\n');
        if (c != '.' && children[c - 'a'] != null) return children[c - 'a'].search(word, index + 1);
        if (c != '.' && children[c - 'a'] == null) return false;

        for (Node n : children) {
            if (n == null) continue;
            if (n.search(word, index + 1)) return true;
        }

        return false;
    }
}

class WordDictionary {
    Node root;
    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        root.addWord(word, 0);
    }

    public boolean search(String word) {
        return root.search(word, 0);
    }
}
