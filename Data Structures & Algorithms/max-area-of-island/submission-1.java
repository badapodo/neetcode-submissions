class Solution {
    int[] dx = new int[] {0, 0, -1, 1};
    int[] dy = new int[] {-1, 1, 0, 0};
    boolean[][] visited;
    int[][] grid;
    int max = 0;
    int h;
    int r;
    public int maxAreaOfIsland(int[][] grid) {
        this.h = grid.length;
        this.r = grid[0].length;
        this.visited = new boolean[h][r];
        this.grid = grid;
        for (int y = 0; y < h; y++) {
            for (int x = 0; x < r; x++) {
                if (grid[y][x] != 1 || visited[y][x]) {
                    continue;
                }
                bfs(y, x);
            }
        }
        return max;
    }

    private void bfs(int y, int x) {

        Deque<int[]> q = new ArrayDeque<>();
        visited[y][x] = true;
        q.addLast(new int[] {y, x});
        int cnt = 1;
        while (!q.isEmpty()) {
            int[] curr= q.removeFirst();
            for (int i = 0; i < 4; i++) {
                int ny = curr[0] + dy[i];
                int nx = curr[1] + dx[i];

                if (!inRange(ny, nx)) {
                    continue;
                }
                if (visited[ny][nx]) {
                    continue;
                }
                if (grid[ny][nx] != 1) {
                    continue;
                }

                visited[ny][nx] = true;
                q.addLast(new int[] {ny, nx});
                cnt++;
            }
        }
        max = Math.max(max, cnt);
    }

    private boolean inRange(int y, int x) {
        return y >= 0 && y < h && x >= 0 && x < r;
    }
}
