class Solution {
    Map<Integer, Integer> map;
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        map = new HashMap<>();
        res = new ArrayList<>();

        for (int n : candidates) {
            map.putIfAbsent(n, 0);
            map.put(n, map.get(n) + 1);
        }
        backtracking(new ArrayList<>(), new ArrayList<>(map.keySet()), target, 0, 0);
        return res;
    }

    private void backtracking(List<Integer> curr, List<Integer> nums, int target, int sum, int index) {
        if (index == nums.size()) {
            if (sum == target) res.add(new ArrayList<>(curr));
            return;
        }

        int n = nums.get(index);
        backtracking(new ArrayList<>(curr), nums, target, sum, index + 1);
        for (int i = 0; i < map.get(n); i++) {
            if (sum + n > target) return;
            curr.add(n);
            sum += n;
            backtracking(new ArrayList<>(curr), nums, target, sum, index + 1);
        }
    }
}
