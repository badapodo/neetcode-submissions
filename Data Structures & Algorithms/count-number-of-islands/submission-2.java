class Solution {
    int[] dx = new int[] {0, 1};
    int[] dy = new int[] {1, 0};
    int[] parent;
    char[][] grid;
    public int numIslands(char[][] grid) {
        this.grid = grid;
        this.parent = new int[grid.length * grid[0].length + 1];
        int cnt = 0;

        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                if (grid[y][x] == '1') {
                    cnt++;
                }
                parent[y * grid[0].length + x] = y * grid[0].length + x;
            }
        }
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                if (grid[y][x] != '1') {
                    continue;
                }

                for (int i = 0; i < 2; i++) {
                    int ny = y + dy[i];
                    int nx = x + dx[i];
                    if (!inRange(ny, nx)) {
                        continue;
                    }
                    if (grid[ny][nx] != '1') {
                        continue;
                    }
                    if (!union(y * grid[0].length + x, ny * grid[0].length + nx)) {
                        cnt--;
                    }
                }
            }
        }

        return cnt;
    }

    private boolean inRange(int y, int x) {
        return y >= 0 && y < grid.length && x >= 0 && x < grid[0].length;
    }

    public boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            parent[rootB] = rootA;
            return false;
        }
        return true;
    }

    public int find(int x) {
        if (parent[x] != x) {
            return parent[x] = find(parent[x]);
        }
        return x;
    }
}
