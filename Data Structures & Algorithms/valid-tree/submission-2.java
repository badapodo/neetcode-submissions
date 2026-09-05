class Solution {
    int[] parent;
    public boolean validTree(int n, int[][] edges) {
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] e : edges) {
            if (!union(e[0], e[1])) {
                return false;
            }
        }
        int base = find(0);
        for (int i = 1; i < n; i++) {
            if (base != find(i)) return false;
        }
        return true;
    }

    private boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            parent[rootA] = rootB;
            return true;
        }

        return false;
    }

    private int find(int x) {
        if (parent[x] != x) {
            return find(parent[x]);
        }

        return parent[x];
    }
}
