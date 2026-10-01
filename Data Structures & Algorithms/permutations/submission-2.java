class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        dfs(nums, new ArrayList<>(), 0);
        return res;
    }

    public void dfs(int[] nums, List<Integer> curr, int visited) {
        if (curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if ((visited & (1 << i)) != 0) {
                continue;
            }
            curr.add(nums[i]);
            dfs(nums, curr, visited | (1 << i));
            curr.remove(curr.size() - 1);
        }
    }
}
