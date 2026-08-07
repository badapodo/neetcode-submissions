class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        
        while (l <= r) {
            int mid = (l + r) >>> 1;
            int num = nums[mid];
            if (num == target) return mid;
            if (nums[l] <= num) {    // 왼쪽 정렬
                if (target >= nums[l] && target < num) {
                    r = mid - 1;
                }
                else l = mid + 1;
            }
            else {  // 오른쪽 정렬
                if (target > num && target <= nums[r]) {
                    l = mid + 1;
                }
                else r = mid - 1;
            }
        }
        return -1;
    }
}
