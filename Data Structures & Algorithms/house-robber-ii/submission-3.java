class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        return Math.max(doRob(nums, 0, n - 2), doRob(nums, 1, n - 1));
    }

    public int doRob(int[] nums, int start, int end) {
        int before1 = 0;
        int before2 = 0;
        int curr = 0;
        for (int i = start; i <= end; i++) {
            curr = Math.max(before2 + nums[i], before1);
            before2 = before1;
            before1 = curr;
        }
        return Math.max(before1, before2);
    }
}
