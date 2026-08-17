class Solution {
    private List<List<Integer>> ret;

    public List<List<Integer>> subsets(int[] nums) {
        ret = new ArrayList<>();
        backtracking(new ArrayList<>(), nums, 0);
        return ret;
    }

    public void backtracking(List<Integer> curr, int[] nums, int depth) {
        if (depth == nums.length) {
            ret.add(new ArrayList<>(curr));
            return;
        }

            curr.add(nums[depth]);
            backtracking(curr, nums, depth + 1);
            curr.remove(curr.size() - 1);
            backtracking(curr, nums, depth + 1);
    }
}
