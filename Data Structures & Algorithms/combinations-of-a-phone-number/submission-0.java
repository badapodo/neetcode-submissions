class Solution {
    private String[] map = new String[] {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private List<String> ret;
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<>();
        ret = new ArrayList<>();
        backtracking(digits, 0, "");
        return ret;
    }

    private void backtracking(String s, int index, String curr) {
        if (s.length() == index) {
            ret.add(curr);
            return;
        }
        StringBuilder sb = new StringBuilder(curr);
        int n = s.charAt(index) - '0';
        for (char c : map[n - 2].toCharArray()) {
            sb.append(c);
            backtracking(s, index + 1, sb.toString());
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
