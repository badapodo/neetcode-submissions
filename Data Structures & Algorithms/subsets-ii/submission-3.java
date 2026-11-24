class Solution {
    int[] nums;
    List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        res = new ArrayList<>();
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

        int next = index + 1;
        while (next < nums.length && nums[next] == nums[index]) {
            next++;
        }
        dfs(next, lst);
    }
}
