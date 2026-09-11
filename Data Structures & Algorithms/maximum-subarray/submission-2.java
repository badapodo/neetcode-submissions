class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;;
        int res = nums[0];

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            res = Math.max(res, sum);

            if (sum < 0) {
                sum = 0;
            }
        }

        return res;
    }
}
