class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int income = 0;
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            income = Math.max(income, prices[i] - min);
        }

        return income;
    }
}
