class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int prevMax = max;
            int prevMin = min;
            int n = nums[i];
            max = Math.max(n, Math.max(prevMax * n, prevMin * n));
            min = Math.min(n, Math.min(prevMax * n, prevMin * n));

            res = Math.max(max, res);
        }

        return res;
    }
}
