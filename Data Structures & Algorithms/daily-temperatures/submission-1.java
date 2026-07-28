class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<int[]> stack = new ArrayDeque<>();
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            int curr = temperatures[i];

            while (!stack.isEmpty()) {
                int[] last = stack.getLast();
                if (curr > last[0]) {
                    res[last[1]] = i - last[1];
                    stack.removeLast();
                    continue;
                }
                break;
            }
            stack.addLast(new int[] {curr, i});
        }
        return res;
    }
}
