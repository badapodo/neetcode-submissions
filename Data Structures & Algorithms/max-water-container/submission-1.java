class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int left = 0;
        int right = n - 1;
        int max = 0;
        while (left < right) {
            int h = Math.min(heights[left], heights[right]);
            max = Math.max(max, h * (right - left));
            if (heights[left] < heights[right]) {
                left++;
                continue;
            }
            right--;
        }
        return max;
    }
}
