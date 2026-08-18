class KthLargest {
    private PriorityQueue<Integer> pq;
    private int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>();
        for (int n : nums) pq.add(n);
        while (pq.size() > k) pq.remove();
    }
    
    public int add(int val) {
        if (pq.size() == 0) {
            pq.add(val);
            return val;
        }
        if (pq.peek() < val) pq.add(val);

        while (pq.size() > k) pq.remove();
        return pq.peek();
    }
}
