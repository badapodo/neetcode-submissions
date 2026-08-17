class Solution {
    int[] dx = new int[] {0, 0, -1, 1};
    int[] dy = new int[] {-1, 1, 0, 0};
    boolean[][] visited;
    boolean ret;
    int r;
    int h;
    public boolean exist(char[][] board, String word) {
        r = board[0].length;
        h = board.length;
        visited = new boolean[h][r];
        ret = false;
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[0].length; x++) {
                if (board[y][x] == word.charAt(0) && !ret)  {
                    visited[y][x] = true;
                    backtracking(y, x, word, 1, board);
                    visited[y][x] = false;
                }
            }
        }
        return ret;
    }

    public void backtracking(int y, int x, String word, int index, char[][] board) {
        if (index == word.length() || ret) {
            ret = true;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny >= 0 && ny < h && nx >= 0 && nx < r) {
                // System.out.print(index + " " + ny + " " + nx);
                if (board[ny][nx] != word.charAt(index) || visited[ny][nx]) continue;
                visited[ny][nx] = true;
                backtracking(ny, nx, word, index + 1, board);
                visited[ny][nx] = false;
            }
        }
    }
}
