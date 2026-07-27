class Solution {
    public int[] twoSum(int[] nums, int target) {
       Map<Integer, Integer> map = new HashMap<>();

       for(int i = 0; i < nums.length; i++) {
        map.put(nums[i], i);
       }

       for(int i = 0; i < nums.length; i++) {
        int find = target - nums[i];
        if(map.containsKey(find) && map.get(find) != i) {
            int[] ret = new int[2];
            ret[0] = i;
            ret[1] = map.get(find);
            return ret;
        }
       }
       int[] ret = new int[0];
        return ret;

    }
}
