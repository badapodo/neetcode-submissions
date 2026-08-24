class Solution {
    int[] parent;

    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }

        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            int a = find(edge[0]);
            int b = find(edge[1]);

            if (a == b) {
                return false;
            }

            parent[b] = a;
        }

        return true;
    }

    private int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }
}