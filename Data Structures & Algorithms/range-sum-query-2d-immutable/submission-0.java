class NumMatrix {
    int[][] left;
    // int[][] up;

    public NumMatrix(int[][] matrix) {
        int h = matrix.length;
        int w = matrix[0].length;
        this.left = new int[h][w];
        // this.right = new int[h][w];

        for (int y = 0; y < h; y++) {
            left[y][0] = matrix[y][0];
            for (int l = 1; l < w; l++) {
                left[y][l] += left[y][l - 1] + matrix[y][l];
            }
        }

        // for (int x = 0; x < w; x++) {
        //     up[x][0] = matrix[x][0];
        //     for (int u = 1; u < h; u++) {
        //         up[u][x] += up[u - 1][x];
        //     }
        // }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int y = row1; y <= row2; y++) {
            sum += left[y][col2];
            if (col1 > 0) {
                sum -= left[y][col1 - 1];
            }
        }

        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */