class Solution {
    boolean[][] cache;
    public String longestPalindrome(String s) {
        int n = s.length();
        cache = new boolean[n][n];
        String res = "";

        for (int i = 0; i < n; i++) {
            cache[i][i] = true;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) { 
                
                if (dp(s, i, j) && res.length() <= j - i) {
                    res = s.substring(i, j + 1);
                }
            }
        }

        return res;
    }

    private boolean dp(String s, int start, int end) {
        if (cache[start][end]) return true;

        if (end - start == 1) {
            if (s.charAt(start) == s.charAt(end)) {
                System.out.print(s.charAt(start) + ", " + s.charAt(end));
                return cache[start][end] = true;
            }
            return false;
        }

        if (dp(s, start + 1, end - 1) && s.charAt(start) == s.charAt(end)) {
            return cache[start][end] = true;
        }

        return false;
    }

}
