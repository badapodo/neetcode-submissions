class Solution {
    int[] parent;
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<int[]> edges = new ArrayList<>();
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int cost =
                    Math.abs(points[i][0] - points[j][0]) +
                    Math.abs(points[i][1] - points[j][1]);

                edges.add(new int[]{i, j, cost});
            }
        }
        
        edges.sort((a, b) -> a[2] - b[2]);
        
        int res = 0;
        int cnt = 0;
        for (int[] e : edges) {
            if (union(e[0], e[1])) {
                res += e[2];
                cnt++;
            }
            if (cnt == n - 1) break;
        }
        if (cnt != n - 1) return -1;
        return res;


    }

    private boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) return false;
        parent[rootA] = rootB;
        return true;
    }

    private int find(int x) {
        if (x != parent[x]) {
            return parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}
