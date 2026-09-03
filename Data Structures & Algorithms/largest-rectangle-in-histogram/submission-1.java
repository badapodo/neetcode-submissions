class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<int[]> stack = new ArrayDeque<>();

        int max = 0;
        int n = heights.length;

        for (int i = 0; i < n; i++) {
            int num = heights[i];
            if (stack.isEmpty() || stack.getLast()[0] < num) {
                stack.addLast(new int[] {num, i});
                continue;
            }
            int idx = 0;
            while (!stack.isEmpty()) {
                if (stack.getLast()[0] >= num) {
                    int[] last = stack.removeLast();
                    idx = last[1];
                    max = Math.max(max, (i - last[1]) * last[0]);
                    continue;
                }
                break;
            }
            stack.addLast(new int[] {num, idx});
        }
        while (!stack.isEmpty()) {
            int[] last = stack.removeLast();
            max = Math.max(max, (n - last[1]) * last[0]);
        }

        return max;
    }
}
