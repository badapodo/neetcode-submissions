class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int h = grid.length;
        int r = grid[0].length;

        int[] dy = new int[] {0, 0, -1, 1};
        int[] dx = new int[] {1, -1, 0, 0};

        boolean[][] visited = new boolean[h][r];
        int cnt = 0;
        int max = 0;
        for (int y = 0; y < h; y++) {
            for (int x = 0; x < r; x++) {
                if (visited[y][x] || grid[y][x] == 0) continue;
                Deque<int[]> queue = new ArrayDeque<>();
                visited[y][x] = true;
                queue.addLast(new int[] {y, x});
                cnt++;
                while (!queue.isEmpty()) {
                    int[] curr = queue.removeFirst();
                    for (int i = 0; i < 4; i++) {
                        int ny = curr[0] + dy[i];
                        int nx = curr[1] + dx[i];
                        if (!(ny >= 0 && ny < h && nx >= 0 && nx < r)) continue;
                        if (visited[ny][nx] || grid[ny][nx] == 0) continue;
                        visited[ny][nx] = true;
                        queue.addLast(new int[] {ny, nx});
                        cnt++;
                    }
                }
                max = Math.max(cnt, max);
                cnt = 0;
            }
        }

        return max;
    }
}
