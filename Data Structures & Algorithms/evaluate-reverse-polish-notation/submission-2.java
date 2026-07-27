class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String s : tokens) {
            if (s.equals("+")) stack.addLast(stack.removeLast() + stack.removeLast());
            else if (s.equals("-")) stack.addLast(-1 * stack.removeLast() + stack.removeLast());
            else if (s.equals("*")) stack.addLast(stack.removeLast() * stack.removeLast());
            else if (s.equals("/")){
                int n2 = stack.removeLast();
                int n1 = stack.removeLast();
                stack.addLast(n1 / n2);
            }
            else stack.addLast(Integer.parseInt(s));
        }
        return stack.removeLast();
    }
}
