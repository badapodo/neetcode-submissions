class Solution {
    PriorityQueue<Integer> pq;
    public int findKthLargest(int[] nums, int k) {
        pq = new PriorityQueue<>();

        for (int n : nums) {
            pq.add(n);
            if (pq.size() > k) pq.remove();
        }

        return pq.peek();
    }
}
