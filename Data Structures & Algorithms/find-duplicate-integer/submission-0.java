class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int last = -1;
        for (int n : nums) {
            if (last == n) return n;
            last = n;
        }
        return -1;
    }
}
