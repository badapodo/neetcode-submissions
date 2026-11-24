class Solution {
    List<List<Integer>> res;
    int[] nums;
    int target;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        this.res = new ArrayList<>();
        this.nums = nums;
        this.target = target;
        dfs(0, 0, new ArrayList<>());
        return res;
    }

    private void dfs(int index, int sum, List<Integer> lst) {
        if (sum == target) {
            res.add(new ArrayList<>(lst));
            return;
        }
        if (sum > target || index >= nums.length) {
            return;
        }



        for (int i = 0; nums[index] * i + sum <= target; i++) {
            for (int j = 0; j < i; j++) {
                lst.add(nums[index]);
            }
            dfs(index + 1, nums[index] * i + sum, lst);
            for (int j = 0; j < i; j++) {
                lst.remove(lst.size() - 1);
            }
        }
    }
}
