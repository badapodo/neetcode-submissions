class Solution {
    int[] parent;
    public int countComponents(int n, int[][] edges) {
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        int cnt = n;
        for (int[] e : edges) {
            if (union(e[0], e[1])) cnt--;
        }

        return cnt;
    }

    private int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    private boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            parent[rootX] = rootY;
            return true;
        }

        return false;
    }
}
