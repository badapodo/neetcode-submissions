class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));   // to, dist
        boolean[] visited = new boolean[n];
        pq.add(new int[] {0, 0});
        int res = 0;

        while(!pq.isEmpty()) {
            int[] curr= pq.remove();
            int currIdx = curr[0];
            int currVal = curr[1];

            if (visited[currIdx]) {
                continue;
            }

            visited[currIdx] = true;    //이거 처리 밑에서 해도 되는지
            res += currVal;

            for (int i = 1; i < n; i++) {
                int nextVal = Math.abs(points[currIdx][0] - points[i][0]) + Math.abs(points[currIdx][1] - points[i][1]);

                if (visited[i]) {
                    continue;
                }

                pq.add(new int[] {i, nextVal});
            }
        }
        return res;
    }
}
