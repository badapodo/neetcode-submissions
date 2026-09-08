class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        for (int i = 2; i < n; i++) {
            int prev = (i > 2 ? nums[i - 3] : 0);

            nums[i] = Math.max(prev, nums[i - 2]) + nums[i];
        }

        return Math.max(nums[n - 1], nums[n - 2]);
    }
}
