class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0;
        int n = arr.length;
        int res = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (i < k - 1) {
                continue;
            }

            if (sum >= threshold * k) {
                res++;
            }

            sum -= arr[i - k + 1];

        }

        return res;
    }
}