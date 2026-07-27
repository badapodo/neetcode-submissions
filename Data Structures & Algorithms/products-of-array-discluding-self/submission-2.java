class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int left = 1;
        int[] ret = new int[n];
        for (int i = 0; i < n; i++) {
            ret[i] = left;
            left *= nums[i];
        }
        
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            ret[i] *= right;
            right *= nums[i];
        }

        return ret;
    }
}