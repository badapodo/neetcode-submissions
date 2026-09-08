class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        int res = 0;
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            res++;
        }

        for (int len = 1; len < n; len++) {
            for (int start = 0; start + len < n; start++) {
                int end = start + len;
                
                if (s.charAt(start) == s.charAt(end)) {
                    if (start == end - 1 || dp[start + 1][end - 1]) {
                        dp[start][end] = true;
                        res++;
                    }
                }
            }
        }
        return res;
    }
}
