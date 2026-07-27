//bfs
//

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.naturalOrder());
        for (int n : nums) {
            pq.add(n);
        }
        int max = 1;
        int lastNum = Integer.MIN_VALUE;
        int index = 1;
        while (!pq.isEmpty()) {
            int curr = pq.remove();
            if (lastNum == curr) continue;
            if (lastNum + 1 == curr) {
                lastNum = curr;
                max = Math.max(max, ++index);
                continue;
            }
            lastNum = curr;
            index = 1;
        }
        return max;
    }
}
