class Solution {
    int[] parent;
    public int numIslands(char[][] grid) {
        int h = grid.length;
        int r = grid[0].length;

        parent = new int[h * r];
        for (int i = 0; i < h * r; i++) {
            parent[i] = i;
        }

        int count = 0;
        for (int i = 0; i < h; i++) {
            for (int t = 0; t < r; t++) {
                if (grid[i][t] == '1') {
                    count++;
                }
            }
        }

        for (int i = 0; i < h; i++) {
            for (int t = 0; t < r; t++) {

                if (grid[i][t] == '0') {
                    continue;
                }

                int curr = i * r + t;

                // 오른쪽 확인
                if (t + 1 < r && grid[i][t + 1] == '1') {
                    int right = i * r + (t + 1);

                    if (union(curr, right)) {
                        count--;
                    }
                }

                // 아래 확인
                if (i + 1 < h && grid[i + 1][t] == '1') {
                    int down = (i + 1) * r + t;

                    if (union(curr, down)) {
                        count--;
                    }
                }
            }
        }
        return count;
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

    private int find(int a) {
        if (parent[a] != a) {
            parent[a] = find(parent[a]);
        }

        return parent[a];
    }
}
