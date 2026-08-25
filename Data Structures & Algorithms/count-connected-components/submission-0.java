class Solution {
    int[] parent;
    public int countComponents(int n, int[][] edges) {
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] e : edges) {
            union(e[0], e[1]);
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(find(i));
        }
        return set.size();
    }

    private int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    private void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            parent[rootX] = rootY;
        }
    }
}
