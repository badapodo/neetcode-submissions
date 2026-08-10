class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] bucket = new int[20001];

        for (int i = 0; i < k; i++) {
            bucket[nums[i] + 10000]++;
        }

        int[] res = new int[nums.length - k + 1];
        int index = 0;
        res[index++] = findMax(bucket);

        for (int i = k; i < nums.length; i++) {
            bucket[nums[i] + 10000]++;
            bucket[nums[i - k] + 10000]--;
            // System.out.print(nums[i]+ ", " + nums[i - k + 1] + "\n");
            res[index++] = findMax(bucket);
        }
        return res;
    }

    private int findMax(int[] nums) {
        for (int i = 20000; i >= 0; i--) {
            if(nums[i] != 0) return i - 10000;
        }
        return 0;
    }
}
