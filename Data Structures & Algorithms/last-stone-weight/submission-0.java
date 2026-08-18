class Solution {
    PriorityQueue<Integer> pq;
    public int lastStoneWeight(int[] stones) {
        pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int n : stones) pq.add(n);
        return run();
    }

    public int run() {
        if (pq.size() == 1) return pq.remove();
        
        while(pq.size() != 0 && pq.size() != 1) {
            int a1 = pq.remove();
            int a2 = pq.remove();

            if (a1 == a2) continue;
            pq.add(Math.abs(a1 - a2));
        }

        if (pq.size() == 0) return 0;
        return pq.remove();
        
    }
}
