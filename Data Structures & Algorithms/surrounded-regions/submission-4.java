class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;

        int[] dy = {0, 0, -1, 1};
        int[] dx = {-1, 1, 0, 0};
        int h = board.length;
        int r = board[0].length;

        Deque<int[]> queue = new ArrayDeque<>();

        for (int x = 0; x < r; x++) {
            if (board[0][x] == 'O') {
                board[0][x] = '#';
                queue.addLast(new int[] {0, x});
            }
            if (board[h - 1][x] == 'O') {
                board[h - 1][x] = '#';
                queue.addLast(new int[] {h - 1, x});
            }
        }
        for (int y = 0; y < h; y++) {
            if (board[y][0] == 'O') {
                board[y][0] = '#';
                queue.addLast(new int[] {y, 0});
            }
            if (board[y][r - 1] == 'O') {
                board[y][r - 1] = '#';
                queue.addLast(new int[] {y, r - 1});
            }
        }

        while (!queue.isEmpty()) {
            int[] curr = queue.removeFirst();

            for (int i = 0; i < 4; i++) {
                int ny = curr[0] + dy[i];
                int nx = curr[1] + dx[i];

                if (ny < 0 || ny >= h || nx < 0 || nx >= r) continue;
                if (board[ny][nx] != 'O') continue;

                board[ny][nx] = '#';
                queue.addLast(new int[] {ny, nx});
            }
        }

        for (int y = 0; y < h; y++) {
            for (int x = 0; x < r; x++) {
                if (board[y][x] == 'O') {
                    board[y][x] = 'X';
                } else if (board[y][x] == '#') {
                    board[y][x] = 'O';
                }
            }
        }
    }
}