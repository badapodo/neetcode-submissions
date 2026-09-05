class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        backtracking(new ArrayList<>(), nums, 0, target, 0);
        return res;
    }

    private void backtracking(List<Integer> curr, int[] nums, int sum, int target, int index) {
        if (sum == target) {
            res.add(new ArrayList<>(curr));
        }
        if (sum > target) return;

        for (int i = index; i < nums.length; i++) {
            curr.add(nums[i]);
            backtracking(curr, nums, sum + nums[i], target, i);
            curr.remove(curr.size() - 1);
        }
    }
}
