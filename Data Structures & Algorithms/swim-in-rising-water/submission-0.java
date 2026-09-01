class Solution {
    public int swimInWater(int[][] grid) {
        int r = grid[0].length;
        int h = grid.length;
        int[] dx = new int[] {0, 0, -1, 1};
        int[] dy = new int[] {-1, 1, 0, 0};

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(grid[a[0]][a[1]], grid[b[0]][b[1]]));    // y, x
        boolean[][] visited = new boolean[h][r];
        pq.add(new int[] {0, 0});

        int ret = 0;
        while (!pq.isEmpty()) {
            int[] curr = pq.remove();
            int y = curr[0];
            int x = curr[1];

            if (visited[y][x]) continue;
            visited[y][x] = true;
            ret = Math.max(ret, grid[y][x]);
            if (visited[h - 1][r - 1]) break;
            
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (!(ny >= 0 && ny < h && nx >= 0 && nx < r)) continue;
                if (visited[ny][nx]) continue;
                pq.add(new int[] {ny, nx});
            }
        }

        return ret;
    }
}
