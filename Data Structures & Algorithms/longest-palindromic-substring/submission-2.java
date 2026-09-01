class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        String res = s.substring(n - 1, n);
        boolean[][] dp = new boolean[n][n];

        for (int i = 0; i < n; i++) dp[i][i] = true;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j + i < n; j++) {
                if (s.charAt(j) == s.charAt(j + i)) {
                    if (i == 1 || dp[j + 1][j + i - 1]) {
                        dp[j][j + i] = true;
                        res = s.substring(j, j + i + 1);
                        continue;
                    }
                }
                dp[j][j + i] = false;
            }
        }
        return res;
    }
}
