class Solution {
    int[][] times;
    List<List<int[]>> graph;    //from, to, dist
    int n;
    int k;
    public int networkDelayTime(int[][] times, int n, int k) {
        this.times = times;
        this.n = n;
        this.k = k;
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < times.length; i++) {
            int from = times[i][0];
            int to = times[i][1];
            int val = times[i][2];

            graph.get(from).add(new int[] {to, val});
        }

        return search(k);
    }

    public int search(int k) {
        int[] dist = new int[n + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        q.add(new int[] {k, 0});
        dist[k] = 0;

        while(!q.isEmpty()) {
            int[] curr = q.remove();
            int currPos = curr[0];
            int currVal = curr[1];

            if (dist[currPos] < currVal) {
                continue;
            }

            for (int[] next : graph.get(currPos)) {
                int nextPos = next[0];
                int nextVal = currVal + next[1];

                if (dist[nextPos] <= nextVal) {
                    continue;
                }
                dist[nextPos] = nextVal;
                q.add(new int[] {nextPos, nextVal});
            }
        }
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res = Math.max(res, dist[i]);
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
