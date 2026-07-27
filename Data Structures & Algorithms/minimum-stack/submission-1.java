class MinStack {
    Deque<Integer> stack;
    Deque<Integer> minStack;


    public MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        stack.addLast(val);
        if (minStack.isEmpty()) {
            minStack.addLast(val);
            return;
        }
        minStack.addLast(minStack.getLast() < val ? minStack.getLast() : val);
    }
    
    public void pop() {
        if (stack.isEmpty()) return;
        stack.removeLast();
        minStack.removeLast();
    }
    
    public int top() {
        return stack.getLast();
    }
    
    public int getMin() {
        return minStack.getLast();
    }
}
