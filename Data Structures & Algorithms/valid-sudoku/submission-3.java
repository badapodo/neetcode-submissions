class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = 9;
        int[] row = new int[9];
        int[] column = new int[9];
        int[] grid = new int[9];

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                if (board[y][x] == '.') continue;
                int num = board[y][x] - '0';
                if ((row[y] & (1 << num)) > 0) return false;
                row[y] = row[y] | (1 << num);
                if ((column[x] & (1 << num)) > 0) return false;
                column[x] = column[x] | (1 << num);
                if ((grid[(y / 3) * 3 + (x / 3)] & (1 << num)) > 0) return false;
                grid[(y / 3) * 3 + (x / 3)] = grid[(y / 3) * 3 + (x / 3)] | (1 << num);
            }
        }
        return true;
    }
}
