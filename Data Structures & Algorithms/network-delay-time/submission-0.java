class Edge {
    int to;
    int cost;

    public Edge(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }
}

class Solution {
    int max = Integer.MAX_VALUE;

    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Edge>> edges = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            edges.add(new ArrayList<>());
        }

        for (int[] t : times) {
            int s = t[0];
            int e = t[1];
            int c = t[2];

            edges.get(s).add(new Edge(e, c));
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, max);

        dist[k] = 0;

        PriorityQueue<Edge> pq =
                new PriorityQueue<>((a, b) -> Integer.compare(a.cost, b.cost));

        pq.add(new Edge(k, 0));

        while (!pq.isEmpty()) {
            Edge curr = pq.poll();

            int currNode = curr.to;
            int currCost = curr.cost;

            if (currCost > dist[currNode]) {
                continue;
            }

            for (Edge next : edges.get(currNode)) {
                int nextNode = next.to;
                int nextCost = currCost + next.cost;

                if (nextCost < dist[nextNode]) {
                    dist[nextNode] = nextCost;
                    pq.add(new Edge(nextNode, nextCost));
                }
            }
        }

        int answer = 0;

        for (int i = 1; i <= n; i++) {
            if (dist[i] == max) {
                return -1;
            }

            answer = Math.max(answer, dist[i]);
        }

        return answer;
    }
}