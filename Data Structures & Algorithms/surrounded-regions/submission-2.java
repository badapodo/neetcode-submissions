class Solution {
    public void solve(char[][] board) {
        int[] dy = new int[] {0, 0, -1, 1};
        int[] dx = new int[] {-1, 1, 0, 0};
        int h = board.length;
        int r = board[0].length;

        Deque<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[h][r];

        for (int x = 0; x < r; x++) {
            if (board[0][x] == 'O') {
                visited[0][x] = true;
                queue.addLast(new int[] {0, x});
            }
            if (board[h - 1][x] == 'O') {
                visited[h - 1][x] = true;
                queue.addLast(new int[] {h - 1, x});
            }
        }

        for (int y = 0; y < h; y++) {
            if (board[y][0] == 'O') {
                visited[y][0] = true;
                queue.addLast(new int[] {y, 0});
            }
            if (board[y][r - 1] == 'O') {
                visited[y][r - 1] = true;
                queue.addLast(new int[] {y, r - 1});
            }
        }

        while (!queue.isEmpty()) {
            int[] curr = queue.removeFirst();

            for (int i = 0; i < 4; i++) {
                int ny = curr[0] + dy[i];
                int nx = curr[1] + dx[i];

                if (!(ny >= 0 && ny < h && nx >= 0 && nx < r)) continue;
                if (visited[ny][nx] || board[ny][nx] == 'X') continue;
                visited[ny][nx] = true;
                queue.addLast(new int[] {ny, nx});
            }
        }

        for (int y = 0; y < h; y++) {
            for (int x = 0; x < r; x++) {
                if (board[y][x] == 'X' || visited[y][x]) continue;
                queue.addLast(new int[] {y, x});
                board[y][x] = 'X';

                while (!queue.isEmpty()) {
                    int[] curr = queue.removeFirst();

                    for (int i = 0; i < 4; i++) {
                        int ny = curr[0] + dy[i];
                        int nx = curr[1] + dx[i];
                        if (!(ny >= 0 && ny < h && nx >= 0 && nx < r)) continue;
                        if (visited[ny][nx] || board[ny][nx] == 'X') continue;

                        board[ny][nx] = 'X';
                        queue.addLast(new int[] {ny, nx});
                    }
                }
            }
        }
    }
}
