
public class Solution {
    static Boolean[][] memo;

    public boolean checkValidString(String s) {
        int n = s.length();
        memo = new Boolean[n + 1][n + 1];
        return dfs(0, 0 ,s);
    }

    private boolean dfs(int i, int open, String s) {
        if (open < 0) return false;
        if (i == s.length()) return open == 0;

        if (memo[i][open] != null) return memo[i][open];


        boolean result;
        if (s.charAt(i) == '(') {
            result = dfs(i + 1, open + 1, s);
        } else if (s.charAt(i) == ')') {
            result = dfs(i + 1, open - 1, s);
        } else {
            result = dfs(i + 1, open, s) ||
                     dfs(i + 1, open + 1, s) ||
                     dfs(i + 1, open - 1, s);
        }

        memo[i][open] = result;
        return result;
    }
}