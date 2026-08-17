class Solution {
    int visited;
    int target;
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        visited = 0;
        target = 0;
        res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) target |= 1 << i;

        backtracking(nums, new ArrayList<>());
        return res;
    }

    private void backtracking(int[] nums, List<Integer> curr) {
        if ((visited & target) == target) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if ((visited & (1 << i)) == (1 << i)) continue;
            visited += 1 << i;
            // System.out.print(i + "\n");
            curr.add(nums[i]);
            backtracking(nums, new ArrayList<>(curr));
            visited -= 1 << i;
            curr.remove(curr.size() - 1);
        }
    }
}