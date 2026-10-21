class Solution {
    int[] pass = new int[] {1, 7, 30};
    public int mincostTickets(int[] days, int[] costs) {
        int n = days[days.length - 1];
        int[] dp = new int[n + 1];
        Set<Integer> set = new HashSet<>();
        for (int d : days) {
            set.add(d);
        }

        for (int day = 1; day <= n; day++) {
            if (!set.contains(day)) {
                dp[day] = dp[day - 1];
                continue;
            }

            int one = dp[day - 1 > 0 ? day - 1 : 0] + costs[0];
            int seven = dp[day - 7 > 0 ? day - 7 : 0] + costs[1];
            int thirteen = dp[day - 30 > 0 ? day - 30 : 0] + costs[2];

            dp[day] = Math.min(one, Math.min(seven, thirteen));
        }

        return dp[n];
    }
}