class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int maxLength = 0;

        for (int num : nums) {
            if (!numSet.contains(num)) continue;

            Queue<Integer> queue = new LinkedList<>();
            queue.add(num);
            numSet.remove(num); 
            
            int currentLength = 1;

            while (!queue.isEmpty()) {
                int curr = queue.poll();

                if (numSet.contains(curr + 1)) {
                    queue.add(curr + 1);
                    numSet.remove(curr + 1);
                    currentLength++;
                }
                
                if (numSet.contains(curr - 1)) {
                    queue.add(curr - 1);
                    numSet.remove(curr - 1);
                    currentLength++;
                }
            }

            maxLength = Math.max(maxLength, currentLength);
        }

        return maxLength;
    }
}