class Solution {
    int[] cache;
    public int rob(int[] nums) {
        // 0번 선택 하는 경우
        // 0번 선택 안하는 경우
        if (nums.length == 1) return nums[0];
        int n = nums.length;

        cache = new int[n];
        cache[0] = nums[0];

        for (int i = 1; i < n - 1; i++) {
            cache[i] = Math.max(dp(i - 2), dp(i - 3)) + nums[i];
        }
        int res1 = Math.max(dp(n - 2), dp(n - 3));
        cache = new int[n];
        for (int i = 1; i < n; i++) {
            cache[i] = Math.max(dp(i - 2), dp(i - 3)) + nums[i];
        }
        int res2 = Math.max(dp(n - 1), dp(n - 2));

        return Math.max(res1, res2);
    }

    private int dp(int i) {
        if (i < 0) return 0;
        return cache[i];
    }
}
