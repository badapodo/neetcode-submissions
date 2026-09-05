class Solution {
    List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        backtracking(new int[n], 0);
        return res;
    }

    private void backtracking(int[] pos, int index) {
        if (pos.length == index) {
            res.add(toString(pos));
            return;
        }
        
        for (int i = 0; i < pos.length; i++) {
            boolean condition = true;
            for (int j = 0; j < index; j++) {
                int y = j;
                int x = pos[j];

                if (condition && (y == index || x == i || Math.abs(y - index) == Math.abs(x - i))) {
                    condition = false;
                }
            }
            if (condition) {
                pos[index] = i;
                backtracking(pos, index + 1);
            }
        }
    }

    private List<String> toString(int[] pos) {
        List<String> res = new ArrayList<>();
        int n = pos.length;
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (pos[i] == j) sb.append('Q');
                else sb.append('.');
            }
            res.add(sb.toString());
        }
        return res;
    }
}
