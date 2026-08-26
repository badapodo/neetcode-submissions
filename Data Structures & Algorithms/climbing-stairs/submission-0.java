class Solution {
    // 1: 1
    // 2: 11, 2
    // 3: 111, 12, 21
    public int climbStairs(int n) {
        int[] dp = new int[2];
        dp[0] = 1;
        dp[1] = 2;

        for (int i = 2; i < n; i++) {
            dp[i % 2] = dp[0] + dp[1];
        }

        return dp[(n - 1) % 2];
    }
}
