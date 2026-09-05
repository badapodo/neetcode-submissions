class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(new ArrayList<>(), candidates, target, 0, 0);
        return res;
    }

    private void backtracking(List<Integer> curr, int[] nums, int target, int sum, int index) {
        if (sum == target) {
            if (sum == target) res.add(new ArrayList<>(curr));
            return;
        }

        if (sum > target || index == nums.length) return;


        curr.add(nums[index]);
        backtracking(curr, nums, target, sum + nums[index], index + 1);
        curr.remove(curr.size() - 1);

        int next = index + 1;
        int base = nums[index];

        while (next < nums.length && base == nums[next]) next++;

        backtracking(curr, nums, target, sum, next);
    }
}
