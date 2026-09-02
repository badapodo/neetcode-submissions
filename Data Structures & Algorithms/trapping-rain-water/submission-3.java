class Solution {
    public int trap(int[] height) {
        Deque<Integer> stack = new ArrayDeque<>();
        int ret = 0;
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            if (stack.isEmpty()) {
                stack.addLast(height[i]);
                max = height[i];
                continue;
            }
            if (height[i] >= max) {
                while (!stack.isEmpty()) {
                    int h = stack.removeLast();
                    ret += max - h;
                }
                max = height[i];   
            }
            stack.addLast(height[i]);
        }
        //System.out.printf("1페이즈: %d\n", ret);
        max = 0;
        while (!stack.isEmpty()) {
            int l = stack.removeLast();
            if (max < l) {
                max = l;
                //System.out.printf("dan: %d\n", max);
                continue;
            }
            ret += max - l;
        }
        //System.out.printf("2페이즈: %d\n", ret);

        return ret;
    }
}
