class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int s : stones) {
            sum += s;
        }

        boolean[] memo = new boolean[sum + 1];
        memo[0] = true;
        int res = sum;
        for (int s : stones) {
            for (int i = sum; i > 0; i--) {
                if (i - s >= 0 && memo[i - s]) {
                    memo[i] = true;
                    res = Math.min(Math.abs(2 * i - sum), res);    // i vs sum - i
                }
            }
        }
        return res;
    }
}