class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int y = 0; y < 9; y++) {
            Set<Character> set = new HashSet<>();
            for (int x = 0; x < 9; x++) {
                if (board[y][x] == '.') continue;
                if (set.contains(board[y][x])) {
                    return false;
                }
                set.add(board[y][x]);
            }
        }
        for (int x = 0; x < 9; x++) {
            Set<Character> set = new HashSet<>();
            for (int y = 0; y < 9; y++) {
                if (board[y][x] == '.') continue;
                if (set.contains(board[y][x])) {
                    return false;
                }
                set.add(board[y][x]);
            }
        }

        for (int subX = 0; subX < 3; subX++) {
            for (int subY = 0; subY < 3; subY++) {
                Set<Character> set = new HashSet<>();
                for(int x = 0; x < 3; x++) {
                    for(int y = 0; y < 3; y++) {
                        int findX = subX * 3 + x;
                        int findY = subY * 3 + y;
                        if (board[findY][findX] == '.') continue;
                        if (set.contains(board[findY][findX])) {
                            return false;
                        }
                        set.add(board[findY][findX]);
                    }
                }
            }
        }
        return true;
    }
}
