class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }

        if (Math.abs(target) > sum || (sum - target) % 2 != 0) {
            return 0;
        }

        int t = (sum - target) / 2;

        int[] memo = new int[t + 1];
        memo[0] = 1;

        for (int n : nums) {
            for (int i = t; i >= n; i--) {
                memo[i] += memo[i - n];
            }
        }

        return memo[t];
    }
}