class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        backtracking(new ArrayList<>(), nums, 0);
        return res;
    }

    private void backtracking(List<Integer> curr, int[] nums, int index) {
        if (index == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }

        int base = nums[index];
        int next = index + 1;

        curr.add(base);
        System.out.print(base);
        backtracking(curr, nums, next);
        curr.remove(curr.size() - 1);

        while (next < nums.length && base == nums[next]) {
            next++;
        }
        backtracking(curr, nums, next);
    }
}
