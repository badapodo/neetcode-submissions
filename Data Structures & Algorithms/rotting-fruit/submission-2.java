class Solution {
    public int orangesRotting(int[][] grid) {
        int[] dy = new int[] {0, 0, -1, 1};
        int[] dx = new int[] { -1, 1, 0, 0};
        
        int h = grid.length;
        int r = grid[0].length;
        Deque<int[]> queue = new ArrayDeque<>();

        int cnt = 0;
        int ret = 0;
        for (int y = 0; y < h; y++) {
            for (int x = 0; x < r; x++) {
                if (grid[y][x] == 1) cnt++;
                if (grid[y][x] == 2) queue.addLast(new int[] {y, x});
            }
        }
        if (cnt == 0) return 0;

        while (!queue.isEmpty()) {
            int[] curr = queue.removeFirst();

            for (int i = 0; i < 4; i++) {
                int ny = curr[0] + dy[i];
                int nx = curr[1] + dx[i];
                if (!(ny >= 0 && ny < h && nx >= 0 && nx < r)) continue;
                if (grid[ny][nx] != 1) continue;
                grid[ny][nx] = grid[curr[0]][curr[1]] + 1; 
                ret = Math.max(grid[ny][nx], ret);
                cnt--;
                queue.addLast(new int[] {ny, nx});
            }
        }
        return cnt == 0 ? ret - 2 : -1;
    }
}
