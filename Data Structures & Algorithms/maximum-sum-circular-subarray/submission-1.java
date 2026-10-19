class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxEnding = nums[0];
        int max = nums[0];
        int minEnding = nums[0];
        int min = nums[0];
        int sum = nums[0];
        int n = nums.length;

        for (int i = 1; i < n; i++) {
            maxEnding = Math.max(nums[i], maxEnding + nums[i]);
            minEnding = Math.min(nums[i], minEnding + nums[i]);
            max = Math.max(max, maxEnding);
            min = Math.min(min, minEnding);
            sum += nums[i];
        }

        if (max < 0) {
            return max;
        }

        return Math.max(max, sum - min);
    }
}