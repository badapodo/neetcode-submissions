class Solution {
    public int numIslands(char[][] grid) {
        int height = grid.length;
        int row = grid[0].length;
        boolean[][] board = new boolean[height][row];

        int[] dy = new int[] {0, 0, -1, 1};
        int[] dx = new int[] {-1, 1, 0, 0};

        int ret = 0;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < row; x++) {
                if (grid[y][x] == '0' || board[y][x]) continue;
                ret++;
                Deque<int[]> queue = new ArrayDeque<>();
                board[y][x] = true;
                queue.addLast(new int[] {y, x});

                while (!queue.isEmpty()) {
                    int[] curr = queue.removeFirst();

                    for (int i = 0; i < 4; i++) {
                        int nx = curr[1] + dx[i];
                        int ny = curr[0] + dy[i];

                        if (!(ny >= 0 && ny < height && nx >= 0 && nx < row)) continue;
                        if (board[ny][nx] || grid[ny][nx] == '0') continue;

                        board[ny][nx] = true;
                        queue.addLast(new int[] {ny, nx});
                    }
                }
            }
        }
        return ret;
    }
}
