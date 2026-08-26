class Solution {
    int[] parent;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length + 1;
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] e : edges) {
            int rootA = find(e[0]);
            int rootB = find(e[1]);

            if (rootA == rootB) return e;
            parent[rootA] = rootB;
        }

        return null;
    }

    public int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }


}
