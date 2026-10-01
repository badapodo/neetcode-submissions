class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, new ArrayList<>(), 0, target);
        
        return res;
    }

    private void dfs(int[] nums, List<Integer> curr, int index, int sum) {
        if (index >= nums.length || sum < 0) {
            if (sum == 0) {
                res.add(new ArrayList<>(curr));
            }
            return;
        }

        if (sum >= 0) {
            curr.add(nums[index]);
            // System.out.print("h");
            dfs(nums, curr, index + 1, sum - nums[index]);
            curr.remove(curr.size() - 1);
        }

        int next = index + 1;
        while (next < nums.length && nums[index] == nums[next]) {
            next++;
        }

        dfs(nums, curr, next, sum);
    }
}
