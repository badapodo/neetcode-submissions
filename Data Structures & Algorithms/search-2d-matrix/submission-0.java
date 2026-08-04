class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix[0].length;
        int l = 0;
        int r = n * matrix.length - 1;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            int[] pos = to2D(mid, n);
            int midNum = matrix[pos[0]][pos[1]];
            if (midNum == target) return true;
            else if(midNum < target) l = mid + 1;
            else r = mid - 1;
        }
        return false;
    }

    private int[] to2D(int pos, int n) {
        return new int[] {pos / n, pos % n};
    }

    private int to1D(int y, int x, int n) {
        return y * n + x;
    }
 }
