class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (i - k >= 0) {
                map.put(nums[i - k], map.get(nums[i - k]) - 1);
                if (map.get(nums[i - k]) == 0) {
                    map.remove(nums[i - k]);
                }
            }
            if (i - k + 1 >= 0) {
                res[i - k + 1] = map.lastKey();
            }
        }
        return res;
    }
}
