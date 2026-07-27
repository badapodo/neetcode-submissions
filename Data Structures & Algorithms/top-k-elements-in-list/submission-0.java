class Solution {
    static class Node implements Comparable<Node>{
        int key;
        int value;

        public Node(int k, int v) {
            key = k;
            value = v;
        }

        public int substr(Node o) {
            return value - o.value;
        }

        public int getKey() {
            return key;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(value, o.value);
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Node> heap = new PriorityQueue<>((a, b) -> a.substr(b));
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            heap.offer(new Node(entry.getKey(), entry.getValue()));
            if (heap.size() > k) {
                heap.poll();
            }
        }
        int[] ret = new int[k];
        for (int i = 0; i < k; i++) {
            ret[i] = heap.poll().getKey();
        }
        return ret;
    }
}
