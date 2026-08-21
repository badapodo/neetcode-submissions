class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int[] dx = new int[] {0, 0, -1, 1};
        int[] dy = new int[] {-1, 1, 0, 0};
        Deque<int[]> queue = new ArrayDeque<>();
        int h = grid.length;
        int r = grid[0].length;

        for (int y = 0; y < h; y++) {
            for (int x = 0; x < r; x++) {
                if (grid[y][x] != 0) continue;
                queue.addLast(new int[] {y, x, 0});
            }
        }
        
        while (!queue.isEmpty()) {
            int[] curr = queue.removeFirst();
            for (int i = 0; i < 4; i++) {
                int ny = dy[i] + curr[0];
                int nx = dx[i] + curr[1];
                int val = curr[2] + 1;
                if (!(ny >= 0 && ny < h && nx >= 0 && nx < r)) continue;
                if (grid[ny][nx] <= val) continue;
                grid[ny][nx] = val;
                queue.addLast(new int[] {ny, nx, val});
            }
        }
    }
}
