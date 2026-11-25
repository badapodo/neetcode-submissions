class Solution {
    List<List<String>> res;
    boolean[][] memo;
    String s;
    public List<List<String>> partition(String s) {
        this.s = s;
        res = new ArrayList<>();
        int n = s.length();
        memo = new boolean[n + 1][n + 1];

        for (int len = 1; len <= n; len++) {
            for (int start = 0; start + len <= n; start++) {
                int e = start + len;

                if (s.charAt(e - 1) == s.charAt(start)) {
                    if (len <= 2 || memo[start + 1][e - 1]) {
                        System.out.println(start + " " + e);
                        memo[start][e] = true;
                    } else {
                        memo[start][e] = false;
                    }
                }
            }
        }
        dfs(0, new ArrayList<>());
        return res;
    }

    private void dfs(int start, List<String> lst) {
        if (start >= s.length()) {
            res.add(new ArrayList<>(lst));
            return;
        }
        for (int e = start + 1; e <= s.length(); e++) {
            
            if (memo[start][e]) {
                lst.add(s.substring(start, e));
                dfs(e, lst);
                lst.remove(lst.size() - 1);
            }
        }
    }


}
