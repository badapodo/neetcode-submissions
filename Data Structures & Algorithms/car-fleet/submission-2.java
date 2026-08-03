class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<double[]> arr = new ArrayList<>();
        int n = position.length;
        
        for (int i = 0; i < n; i++) {
            double time = (double) (target - position[i]) / speed[i];
            arr.add(new double[] {position[i], time});
        }
    
        arr.sort((a, b) -> Double.compare(b[0], a[0]));
        
        Deque<Double> stack = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            double num = arr.get(i)[1];
            if (stack.isEmpty()) {
                stack.addLast(num);
                continue;
            }

            double last = stack.getLast();
            
            if (last >= num) continue;
            
            stack.addLast(num);
        }
        
        return stack.size();
    }
}