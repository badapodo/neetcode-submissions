class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int half = 0;

        for (int num : nums) {
            half += num;
        }

        if (half % 2 != 0) {
            return false;
        }

        half /= 2;

        boolean[] dp = new boolean[half + 1];
        dp[0] = true;

        for (int curr : nums) {
            for (int i = half; i > 0; i--) {
                if (i - curr >= 0 && dp[i - curr]) {
                    dp[i] = true;
                }
            }
        }

        return dp[half];
    }
}
