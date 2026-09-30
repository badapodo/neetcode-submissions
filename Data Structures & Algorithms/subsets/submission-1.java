class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> path = new ArrayList<>();
        dfs(nums, 0, path);
        return res;
    }

    public void dfs(int[] nums, int idx, List<Integer> path) {
        if (idx >= nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        path.add(nums[idx]);
        dfs(nums, idx + 1, path);
        path.remove(path.size() - 1);
        dfs(nums, idx + 1, path);
    }
}
