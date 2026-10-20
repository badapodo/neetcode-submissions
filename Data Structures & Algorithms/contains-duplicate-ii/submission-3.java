class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> window = new HashSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (window.contains(nums[i])) {
                return true;
            }

            if (window.size() < k) {
                window.add(nums[i]);
                continue;
            }
            window.add(nums[i]);
            window.remove(nums[i - k]);
        }

        return false;
    }
}