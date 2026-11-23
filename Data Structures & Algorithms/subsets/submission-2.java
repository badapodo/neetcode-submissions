class Solution {
    List<List<Integer>> res = new ArrayList<>();
    int[] nums;
    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        dfs(0, new ArrayList<>());
        return res;
    }

    private void dfs(int index, List<Integer> lst) {
        if (index == nums.length) {
            res.add(new ArrayList<>(lst));
            return;
        }
        lst.add(nums[index]);
        dfs(index + 1, lst);
        lst.remove(lst.size() - 1);
        dfs(index + 1, lst);
    }
}
