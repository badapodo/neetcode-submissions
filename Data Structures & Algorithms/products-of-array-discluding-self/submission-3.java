class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        left[0] = nums[0];
        right[nums.length - 1] = nums[nums.length - 1];

        for (int l = 1; l < nums.length; l++) {
            int r = nums.length - 1 - l;
            left[l] = left[l - 1] * nums[l];
            right[r] = right[r + 1] * nums[r];
        }

        int[] ret = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int num = 1;
            if (i > 0) num *= left[i - 1];
            if (i < nums.length - 1) num *= right[i + 1];
            ret[i] = num;
        }

        return ret;
    }
}  
