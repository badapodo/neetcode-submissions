class Solution {
    private List<List<Integer>> ret;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        ret = new ArrayList<>();
        List<Integer> start = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            start.add(0);
        }

        backtracking(start, nums, 0, 0, target);
        return convertRes(ret, nums);
    }

    private List<List<Integer>> convertRes(List<List<Integer>> res, int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();

        for (List<Integer> l : res) {
            List<Integer> curr = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                for (int t = 0; t < l.get(i); t++) {
                    curr.add(nums[i]);
                }
            }
            ret.add(curr);
        }
        return ret;
    }

    private void backtracking(List<Integer> curr, int[] nums, int depth, int sum, int target) {
        if (depth == nums.length && sum == target) {
            ret.add(new ArrayList<>(curr));
            return;
        }

        if (depth == nums.length) return;

        int currNum = (target - sum) / nums[depth];
        int currSum = sum + nums[depth] * currNum;
        curr.set(depth, currNum);

        backtracking(curr, nums, depth + 1, currSum, target);
        while (--currNum >= 0) {
            currSum -= nums[depth];
            curr.set(depth, currNum);
            backtracking(curr, nums, depth + 1, currSum, target);
        }

    }
}
