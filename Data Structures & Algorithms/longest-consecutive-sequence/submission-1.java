class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }
        Queue<Integer> pq = new PriorityQueue<>();
        pq.addAll(set);
        int maxSq = 1;
        int tmpSq = 1;
        int lastNum = pq.poll();
        while (!pq.isEmpty()) {
            int peek = pq.poll();
            if (peek == lastNum + 1) {
                tmpSq++;
                maxSq = Math.max(maxSq, tmpSq);
                lastNum = peek;
            }
            else {
                tmpSq = 1;
                lastNum = peek;
            }
        }
        return maxSq;
    }
}
