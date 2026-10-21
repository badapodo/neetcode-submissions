class Solution {
    int[] nums;
    int target;
    Map<String, Integer> memo;
    public int findTargetSumWays(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        memo = new HashMap<>();
        return dfs(0, 0);
    }

    private int dfs(int index, int sum) {
        if (index == nums.length) {
            if (sum == target) {
                return 1;
            }
            return 0;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(index).append("#").append(sum);

        if (memo.containsKey(sb.toString())) {
            return memo.get(sb.toString());
        }

        int result = dfs(index + 1, sum + nums[index]) + dfs(index + 1, sum - nums[index]);
        memo.put(sb.toString(), result);
        return result;
    }
}
