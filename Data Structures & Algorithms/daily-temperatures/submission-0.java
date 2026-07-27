class Solution {

    class Node {
        int value;
        int index;

        public Node(int temperature, int index) {
            this.value = temperature;
            this.index = index;
        }

        public int getTemperature() {
            return value;
        }

        public int getIndex() {
            return index;
        }
    }

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Node> stack = new Stack<>();
        int[] ret = new int[temperatures.length];

        for(int index = 0; index < temperatures.length; index++) {
            while(!stack.isEmpty() && stack.peek().getTemperature() < temperatures[index]) {
                Node top = stack.pop();
                ret[top.getIndex()] = index - top.getIndex();
            }
            stack.push(new Node(temperatures[index], index));
        }
        return ret;
    }
}
