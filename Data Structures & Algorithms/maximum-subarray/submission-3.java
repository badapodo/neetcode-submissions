class Solution {
    public int maxSubArray(int[] nums) {
        int ending = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            ending = Math.max(nums[i], ending + nums[i]);
            max = Math.max(ending, max);
        }

        return max;
    }
}
