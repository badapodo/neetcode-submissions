class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;

        for (int n : nums) {
            sum += n;
        }

        if (sum % 2 != 0) {
            return false;
        }

        int mid = sum / 2;
        
        boolean[] dp = new boolean[mid + 1];
        dp[0] = true;

        for (int n : nums) {
            for (int i = mid; i > 0; i--) {
                if (i >= n && dp[i - n]) {
                    System.out.print("hi");
                    dp[i] = true;
                }
            }
        }

        return dp[mid];

    }
}
