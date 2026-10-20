class NumArray {
    int sum;
    int[] left;
    int[] right;
    public NumArray(int[] nums) {
        int n = nums.length;
        this.left = new int[n];
        this.right = new int[n];
        left[0] = nums[0];
        right[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            int r = n - i - 1;
            left[i] = left[i - 1] + nums[i];
            right[r] = right[r + 1] + nums[r];
        }
        this.sum = left[n - 1];
    }
    
    public int sumRange(int left, int right) {
        int sum = this.sum;
        if (left > 0) {
            sum -= this.left[left - 1];
        }
        if (right < this.left.length - 1) {
            sum -= this.right[right + 1];
        }

        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */