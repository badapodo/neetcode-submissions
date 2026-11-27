class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] t : times) {
            graph.get(t[0]).add(new int[] {t[1], t[2]});
        }
        int[] visited = new int[n + 1];
        Arrays.fill(visited, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        visited[k] = 0;
        pq.add(new int[] {k, 0});
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if (curr[1] > visited[curr[0]]) {
                continue;
            }

            for (int[] next : graph.get(curr[0])) {
                int nNode = next[0];
                int nWeight = next[1] + curr[1];

                if (nWeight < visited[nNode]) {
                    visited[nNode] = nWeight;
                    pq.add(new int[] {nNode, nWeight});
                }
            }
        }
        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, visited[i]);
        }

        return max == Integer.MAX_VALUE ? -1 : max;
    }
}
