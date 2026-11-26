class Solution {
    int[] dy = new int[] {0, 0, -1, 1};
    int[] dx = new int[] {-1, 1, 0, 0};
    boolean[][] visited;
    int[][] grid;
    int h;
    int r;
    int cnt;
    int time;
    Deque<int[]> q = new ArrayDeque<>();

    public int orangesRotting(int[][] grid) {
        this.h = grid.length;
        this.r = grid[0].length;

        this.visited = new boolean[h][r];
        this.grid = grid;
        this.cnt = 0;
        for (int y = 0; y < h; y++) {
            for (int x = 0; x < r; x++) {
                if (grid[y][x] == 1) {
                    cnt++;
                }
                if (visited[y][x]) {
                    continue;
                }
                if (grid[y][x] == 2) {
                    visited[y][x] = true;
                    q.addLast(new int[] {y, x, 0});
                }
            }
        }
        bfs();
        return cnt == 0 ? time : -1;
    }

    private void bfs() {
        int time = 0;

        while(!q.isEmpty()) {
            int[] curr = q.removeFirst();

            for (int i = 0; i < 4; i++) {
                int ny = curr[0] + dy[i];
                int nx = curr[1] + dx[i];
                time = Math.max(curr[2], time);

                if (!inRange(ny, nx)) {
                    continue;
                }
                if (visited[ny][nx]) {
                    continue;
                }
                if (grid[ny][nx] == 1) {
                    visited[ny][nx] = true;
                    cnt--;
                    q.addLast(new int[] {ny, nx, curr[2] + 1});
                }
            }
        }
        this.time = Math.max(this.time, time);
    }

    private boolean inRange(int y, int x) {
        return y >= 0 && y < h && x >= 0 && x < r;
    }
}