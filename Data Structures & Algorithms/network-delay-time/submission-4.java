class Solution {
    List<List<int[]>> graph;
    public int networkDelayTime(int[][] times, int n, int k) {
        graph = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] t : times) {
            int source = t[0];
            int target = t[1] ;
            int val = t[2];
            graph.get(source).add(new int[] {target, val});
        }

        int[] dist = new int[n + 1];
        int max = Integer.MAX_VALUE;
        for (int i = 0; i < n + 1; i++) {
            dist[i] = max;
        }

        dist[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[] {k, 0});
        while (!pq.isEmpty()) {
            int[] curr = pq.remove();
            int source = curr[0];
            int val = curr[1];

            if (dist[source] < val) {
                continue;
            }

            for (int[] e : graph.get(source)) {
                int to = e[0];
                int nextVal = val + e[1];

                if (dist[to] <= nextVal) {
                    continue;
                }
                dist[to] = nextVal;
                pq.add(new int[] {to, nextVal});
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, dist[i]);
            if (ans == max) return -1;
        }
        return ans;
    }
}
