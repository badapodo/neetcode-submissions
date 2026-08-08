
class Solution {
    public int maxProfit(int[] prices) {
        Deque<Integer> stack = new ArrayDeque<>();
        int maxProfit = 0;

        for (int price : prices) {

            while (!stack.isEmpty() && stack.peekLast() > price) {
                stack.removeLast(); // pop
            }

            stack.addLast(price); // push
            int currentMin = stack.peekFirst(); 
            maxProfit = Math.max(maxProfit, price - currentMin);
        }

        return maxProfit;
    }
}