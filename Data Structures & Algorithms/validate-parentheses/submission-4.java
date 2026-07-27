class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        int n = s.length();
        char[] arr = s.toCharArray();
        for (int i = 0; i < n; i++) {
            char c = arr[i];
            if (c == '{' || c == '(' || c== '[') {
                stack.addLast(c);
                continue;
            }
            if (stack.isEmpty()) return false;
            if (c == ']' && stack.removeLast() == '[') continue;
            if (c == ')' && stack.removeLast() == '(') continue;
            if (c == '}' && stack.removeLast() == '{') continue;
            return false;
        }
        if (stack.isEmpty()) return true;
        return false;
    }
}
