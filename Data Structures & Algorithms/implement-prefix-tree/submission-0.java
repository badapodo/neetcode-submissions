class PrefixTree {
    Set<String> startSet;
    Set<String> set;
    public PrefixTree() {
         set = new HashSet<>();
         startSet = new HashSet<>();
    }

    public void insert(String word) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            sb.append(c);
            startSet.add(sb.toString());
        } 
        set.add(word);
    }

    public boolean search(String word) {
        return set.contains(word);
    }

    public boolean startsWith(String prefix) {
        return startSet.contains(prefix);
    }
}
