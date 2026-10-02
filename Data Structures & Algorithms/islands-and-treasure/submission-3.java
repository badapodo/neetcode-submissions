class Solution {
    int[] dx = new int[] { 0, 0, -1, 1};
    int[] dy = new int[] {-1, 1, 0, 0};
    public void islandsAndTreasure(int[][] grid) {
        Deque<int[]> queue = new ArrayDeque<>();
        int h = grid.length;
        int r = grid[0].length;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < r; j++) {
                if (grid[i][j] == 0) {
                    queue.addLast(new int[] {i, j});
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] curr = queue.removeFirst();
            for (int i = 0; i < 4; i++) {
                int ny = curr[0] + dy[i];
                int nx = curr[1] + dx[i];
                int nv = grid[curr[0]][curr[1]] + 1;

                if (!(ny >= 0 && ny < h && nx >= 0 && nx < r)) {
                    continue;
                }
                if (grid[ny][nx] == -1 || grid[ny][nx] <= nv) {
                    continue;
                }

                grid[ny][nx] = nv;
                queue.addLast(new int[] {ny, nx});
            }
        }
    }
}
