class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int zero = 0;
            int one = 0;

            for (char c : str.toCharArray()) {
                if (c == '0') zero++;
                else one++;
            }

            for (int i = m; i >= 0; i--) {   // 0
                for (int j = n; j >= 0; j--) {   //1
                    if (i - zero >= 0 && j - one >= 0) {
                        dp[i][j] = Math.max(dp[i - zero][j - one] + 1, dp[i][j]);
                    }
                }
            }
        }

        return dp[m][n];
    }
}