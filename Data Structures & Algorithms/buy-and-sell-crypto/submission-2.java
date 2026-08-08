class Solution {
    public int maxProfit(int[] prices) {
        int[] min = new int[prices.length];
        int[] max = new int[prices.length];
        min[0] = prices[0];
        max[prices.length - 1] = prices[prices.length - 1];

        for (int i = 1; i < prices.length; i++) {
            int r = prices.length - i - 1;
            min[i] = min[i - 1] > prices[i] ? prices[i] : min[i - 1];
            max[r] = max[r + 1] > prices[r] ? max[r + 1] : prices[r];
        }

        int ret = 0;
        for (int i = 0; i < prices.length; i++) {
            ret = ret > max[i] - min[i] ? ret : max[i] - min[i];
        }
        return ret;
    }
}
