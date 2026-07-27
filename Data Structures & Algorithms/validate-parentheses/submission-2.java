class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(isOpen(ch)) {
                stack.push(ch);
                continue;
            } else {
                if(stackValid(stack, ch)) {
                    stack.pop();
                    continue;
                }
                return false;
            }
        }
        
        if(stack.isEmpty()) {
            return true;
        } 

        return false;
    }

    public boolean stackValid(Stack<Character> stack, char ch) {
        if(stack.isEmpty()) {
            return false;
        }
        char top = stack.peek();
        if(top == '(') {
            return ch == ')';
        } else if(top == '[') {
            return ch == ']';
        } else {
            return ch == '}';
        }
    }

    public boolean isOpen(char ch) {
        return ch == '[' || ch == '{' || ch == '(';
    }
}
