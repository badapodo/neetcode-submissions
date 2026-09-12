class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] count = new int[n];

        for (int i = 0; i < n; i++) {
            if (count[n - 1] != 0) return count[n - 1];
            for (int j = 1; j <= nums[i]; j++) {
                int curr = i + j;
                
                if (curr >= n) break;
                if (count[curr] != 0) {
                    continue;
                }
                count[curr] = count[i] + 1;
                // System.out.print(curr + " " + count[curr] + "\n");
            }
        }

        return count[n - 1];
    }
}
