class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[][] cache = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cache[i][j] = -1;
            }
        }

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int leftProduct = get(0, i - 1, cache, nums);
            int rightProduct = get(i + 1, n - 1, cache, nums);
            result[i] = leftProduct * rightProduct;
        }
        return result;
    }

    public int get(int start, int end, int[][] cache, int[] nums) {
        if (start > end) {
            return 1;
        }

        if (cache[start][end] != -1) {
            return cache[start][end];
        }

        if (start == end) {
            return cache[start][end] = nums[start];
        }

        int mid = (start + end) / 2;
        int left = get(start, mid, cache, nums);
        int right = get(mid + 1, end, cache, nums);
        return cache[start][end] = left * right;
    }
}
