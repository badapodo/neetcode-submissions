class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.putIfAbsent(n, 0);
            map.put(n, map.get(n) + 1);
        }
        int[][] t = new int[map.size()][2];
        int idx = 0;
        for (int n : map.keySet()) {
            t[idx++] = new int[] {n, map.get(n)};
        }
        Arrays.sort(t, (a, b) -> b[1] - a[1]);
        int[] ret = new int[k];
        for (int i = 0; i < k; i++) {
            ret[i] = t[i][0];
        }
        return ret;
    }
}
