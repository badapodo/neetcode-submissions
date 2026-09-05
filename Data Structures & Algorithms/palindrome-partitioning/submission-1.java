class Solution {
    boolean[][] cache;
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        int n = s.length();
        res = new ArrayList<>();
        cache = new boolean[n][n];
        
        for (int i = 0; i < n; i++) {
            cache[i][i] = true;
        }

        backtracking(new ArrayList<>(), s, 0);

        // for (int start = 0; start < n; start++) {
        //     for (int length = 0; length + start < n; length++) {
        //         int end = length + start;
        //         if (dp(s, start, end)) {
        //             ret.add(s.substring(start, end + 1));
        //         }
        //     }
        // }
        return res;
    }

    private void backtracking(List<String> curr, String s, int index) {
        if (index == s.length()) {
            System.out.print(curr.size() + " ");
            res.add(new ArrayList<>(curr));
            return;
        }

        int start = index;

        for (int end = index; end < s.length(); end++) {
            if (!dp(s, start, end)) {
                continue;
            }
            curr.add(s.substring(start, end + 1));
            backtracking(curr, s, end + 1);
            curr.remove(curr.size() - 1);
        }
    }

    private boolean dp(String s, int start, int end) {
        if (cache[start][end]) {
            return true;
        } 

        if (s.charAt(start) == s.charAt(end)) {
            if (start == end - 1) {
                return cache[start][end] = true;
            }

            return cache[start][end] = dp(s, start + 1, end - 1);
        }

        return cache[start][end] = false;
    }
}
