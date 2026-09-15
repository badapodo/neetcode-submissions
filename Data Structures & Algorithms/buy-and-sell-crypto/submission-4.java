class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] max = new int[n];
        int[] min = new int[n];

        min[0] = prices[0];
        max[n - 1] = prices[n - 1];

        for (int left = 1; left < n; left++) {
            int right = n - left - 1;

            max[right] = Math.max(prices[right], max[right + 1]);
            min[left] = Math.min(prices[left], min[left - 1]);
        }
        int maxIncome = 0;
        for (int i = 0; i < n; i++) {
            maxIncome = Math.max(maxIncome, max[i] - min[i]);
        }

        return maxIncome;
    }
}
