class Solution {
    int[] dy = new int[] {0, 0, -1, 1};
    int[] dx = new int[] {-1, 1, 0, 0};

    public int orangesRotting(int[][] grid) {
        int h = grid.length;
        int r = grid[0].length;
        Deque<int[]> queue = new ArrayDeque<>();

        int cnt = h * r;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < r; j++) {
                if (grid[i][j] == 0) {
                    cnt--;
                }

                if (grid[i][j] == 2) {
                    queue.addLast(new int[] {i, j});
                }
            }
        }

        int time = 0;
        int left = queue.size();
        while (!queue.isEmpty()) {
            if (left == 0) {
                left = queue.size();
                time++;
            }
            int[] curr = queue.removeFirst();
            left--;
            cnt--;
            for (int i = 0; i < 4; i++) {
                int ny = curr[0] + dy[i];
                int nx = curr[1] + dx[i];
                if (!(ny >= 0 && ny < h && nx >= 0 && nx < r)) {
                    continue;
                }
                if (grid[ny][nx] != 1) {
                    continue;
                }

                grid[ny][nx] = 2;
                queue.addLast(new int[] {ny, nx});
            }
        }
        return cnt == 0 ? time : -1;
    }
}
