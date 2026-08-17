class Solution {
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        backtracking(s, 0, new ArrayList<>());
        return res;
    }

    private void backtracking(String s, int index, List<String> curr) {
        if (index == s.length()) {
            res.add(new ArrayList<>(curr));
            return;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = index; i < s.length(); i++) {
            sb.append(s.charAt(i));
            index += 1;
            if (!isPalindrome(sb.toString())) continue;
            curr.add(sb.toString());
            backtracking(s, index, new ArrayList<>(curr));
            curr.remove(curr.size() - 1);
        }

    }

    private boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) return false;
        }

        return true;
    }

    
}
