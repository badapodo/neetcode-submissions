class Solution {
        public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int cnt = 0;
        for(int num : nums) {
            set.add(num);
            cnt++;
        }
        return cnt != set.size();
    }
}
