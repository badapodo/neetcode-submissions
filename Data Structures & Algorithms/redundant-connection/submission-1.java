class Solution {
    int[] parent;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        for (int[] e : edges) {
            if (!union(e[0], e[1])) {
                return e;
            }
        }
        return null;
    }

    private boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            parent[rootB] = rootA;
            return true;
        }
        return false;
    }

    private int find(int x) {
        if (parent[x] != x) {
            return parent[x] = find(parent[x]);
        }
        return x;
    }
}
