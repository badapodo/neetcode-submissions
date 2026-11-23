class Solution {
    public int maxProfit(int[] prices) {
        int min = 100;
        int max = 0;
        int n = prices.length;
        for (int i = 0; i < n; i++) {
            int curr = prices[i];
            min = Math.min(min, curr);
            max = Math.max(max, curr - min);
        }

        return max;
    }
}
