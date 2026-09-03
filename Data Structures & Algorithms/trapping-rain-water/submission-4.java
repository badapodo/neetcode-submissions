class Solution {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;

        int lMax = 0;
        int rMax = 0;
        int ret = 0;

        while (l < r) {
            if (height[l] < height[r]) {
                lMax = Math.max(lMax, height[l]);
                ret += lMax - height[l++];
                continue;
            }
            rMax = Math.max(rMax, height[r]);
            ret += rMax - height[r--];
        }

        return ret;
    }
}
