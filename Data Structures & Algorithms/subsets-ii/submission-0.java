class Solution {
    Map<Integer, Integer> map;
    List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        map = new HashMap<>();
        res = new ArrayList<>();

        for (int n : nums) {
            map.putIfAbsent(n, 0);
            map.put(n, map.get(n) + 1);
        }

        backtracking(new ArrayList<>(), new ArrayList<>(map.keySet()), 0);
        return res;
    }

    private void backtracking(List<Integer> curr, List<Integer> nums, int index) {
        if (index == nums.size()) {
            // System.out.print(index);
            res.add(new ArrayList<>(curr));
            return;
        }

        backtracking(new ArrayList<>(curr), nums, index + 1);
        int n = nums.get(index);
        
        for (int i = 0; i < map.get(n); i++) {
            curr.add(n);
            backtracking(new ArrayList<>(curr), nums, index + 1);
        }
    }
}
