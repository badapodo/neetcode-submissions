class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> curr = new ArrayList<>();
        dfs(nums, 0, curr, target);

        return res;

    }

    private void dfs(int[] nums, int index, List<Integer> arr, int sum) {
        if (index >= nums.length) {
            if (sum == 0) {
                res.add(new ArrayList<>(arr));
            }
            return;
        }

        dfs(nums, index + 1, arr, sum);
        if (sum - nums[index] >= 0) {
            arr.add(nums[index]);
            dfs(nums, index, arr, sum - nums[index]);
            arr.remove(arr.size() - 1);
        }
    }
}
