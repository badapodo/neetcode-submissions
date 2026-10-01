class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        dfs(nums, new ArrayList<>(), 0);
        return res;
    }

    private void dfs(int[] nums, List<Integer> curr, int index) {
        if (index >= nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[index]);
        dfs(nums, curr, index + 1);
        curr.remove(curr.size() - 1);

        int next = index + 1;
        while (next < nums.length && nums[next] == nums[index]) {
            next++;
        }

        dfs(nums, curr, next);
    }
}
