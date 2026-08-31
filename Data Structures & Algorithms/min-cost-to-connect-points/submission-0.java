class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        boolean[] visited = new boolean[n];

        pq.add(new int[]{0, 0});

        int sum = 0;
        int count = 0;

        while (!pq.isEmpty() && count < n) {
            int[] curr = pq.remove();

            int cost = curr[0];
            int idx = curr[1];

            if (visited[idx]) {
                continue;
            }

            visited[idx] = true;
            sum += cost;
            count++;

            int x = points[idx][0];
            int y = points[idx][1];

            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    continue;
                }

                int nextX = points[i][0];
                int nextY = points[i][1];

                int distance =
                    Math.abs(x - nextX)
                    + Math.abs(y - nextY);

                pq.add(new int[]{distance, i});
            }
        }

        return sum;
    }
}