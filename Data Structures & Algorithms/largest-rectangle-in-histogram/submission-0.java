class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<int[]> stack = new ArrayDeque<>();

        int max = 0;
        int n = heights.length;
        // 마지막 숫자가 더 작으면 이전거 삭제 후 인덱스 조정
        for (int i = 0; i < n; i++) {
            int num = heights[i];
            if (stack.isEmpty() || stack.getLast()[0] < num) {
                System.out.print(num + ", " + i +"\n");
                stack.addLast(new int[] {num, i});
                continue;
            }
            // System.out.print("hi \n");
            int idx = 0;
            while (!stack.isEmpty()) {
                // System.out.print(stack.getLast()[0] +"\n");
                if (stack.getLast()[0] >= num) {
                    // System.out.print(num + ", " + stack.getLast()[0] +"\n");
                    int[] last = stack.removeLast();
                    idx = last[1];
                    max = Math.max(max, (i - last[1]) * last[0]);
                    continue;
                }
                break;
            }
            // System.out.print(num + ", " + idx +"\n");
            stack.addLast(new int[] {num, idx});
        }
        while (!stack.isEmpty()) {
            int[] last = stack.removeLast();
            max = Math.max(max, (n - last[1]) * last[0]);
            // System.out.print((n - last[1]) * last[0] +"\n" + "max: " + max + "\n");
        }

        return max;
    }
}
