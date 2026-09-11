class Solution {
    public boolean canJump(int[] nums) {
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > max) continue;
            if (i == nums.length - 1) {
                return true;
            }
            int curr = nums[i];
            max = Math.max(curr + i, max);
            
        }

        return false;
    }
}
