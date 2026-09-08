class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if (n == 1) return cost[0];
        if (n == 2) return Math.min(cost[0], cost[1]);
        int prev = cost[0];
        int curr = cost[1];
        for (int i = 2; i < n; i++) {
            int tmp = Math.min(prev, curr) + cost[i];
            prev = curr;
            curr = tmp;
        }

        return Math.min(prev, curr);
    }
}
