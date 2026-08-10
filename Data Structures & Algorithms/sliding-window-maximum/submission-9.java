class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int ret[] = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (!deque.isEmpty() && i - k >= deque.getFirst()) deque.removeFirst();

            while (!deque.isEmpty() && ((nums[deque.getLast()] <= num))) {
                deque.removeLast();
            }
            deque.addLast(i);
            if (i < k - 1) continue;
            ret[index++] = nums[deque.getFirst()];
        }
        return ret;
    }
}
