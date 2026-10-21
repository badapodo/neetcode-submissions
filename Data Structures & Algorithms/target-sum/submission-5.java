class Solution {
    Map<Integer, Map<Integer, Integer>> memo;
    public int findTargetSumWays(int[] nums, int target) {
        memo = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            memo.putIfAbsent(i, new HashMap<>());
        }
        memo.get(0).put(nums[0], 1);
        memo.get(0).put(-nums[0], memo.get(0).getOrDefault(-nums[0], 0) + 1);

        for (int i = 1; i < nums.length; i++) {
            for (Map.Entry<Integer, Integer> entry : memo.get(i - 1).entrySet()) {
                int plus = entry.getKey() + nums[i];
                int pVal = memo.get(i).getOrDefault(plus, 0) + entry.getValue();
                memo.get(i).put(plus, pVal);

                int minus = entry.getKey() - nums[i];
                int mVal = memo.get(i).getOrDefault(minus, 0) + entry.getValue();
                memo.get(i).put(minus, mVal);
            }
        }

        return memo.get(nums.length - 1).getOrDefault(target, 0);
    }
}
