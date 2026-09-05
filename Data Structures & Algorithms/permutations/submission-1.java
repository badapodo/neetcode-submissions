class Solution {
    int visited;
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        visited = 0;
        res = new ArrayList<>();
        backtracking(new ArrayList<>(), nums);
        return res;
    }

    private void backtracking(List<Integer> curr, int[] nums) {
        if (curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if ((visited & 1 << i) == 1 << i) {
                continue;
            }
            visited |= 1 << i;
            curr.add(nums[i]);
            backtracking(curr, nums);

            visited &= ~(1 << i);
            curr.remove(curr.size() - 1);
        }
    }
}
