class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }

        int max = 0;

        for (int n : nums) {
            if (set.contains(n - 1)) {
                continue;
            }
            int curr = n;
            int cnt = 0;
            while (set.contains(curr)) {
                cnt++;
                curr++;
            }

            max = Math.max(max, cnt);
        }

        return max;
    }
}
