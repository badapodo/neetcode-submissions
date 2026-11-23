class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int r = n - 1;
        int l = 0;

        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return -1;
    }
}
