class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int[] gap = new int[n];

        for (int i = 0; i < n; i++) {
            gap[i] = gas[i] - cost[i];
        }

        int left = 0;
        int start = 0;
        for (int i = 0; i < n; i++) {
            if (left < 0) {
                left = 0;
                start = i;
            }

            left += gap[i];
        }

        int curr = start;
        int cnt = 0;
        left = 0;
        while (cnt != n){
            // System.out.println(curr + " " + left);
            if (curr == n) {
                curr = 0;
            }

            left += gap[curr++];
            cnt++;

            if (left < 0) {
                return -1;
            }
        }
        return start;
    }
}
