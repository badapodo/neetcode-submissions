class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];      // 앞에서부터 n번째 까지의 단어를 만들 수 있는가?
        dp[0] = true;
        
        for (int i = 1; i <= n; i++) {
            for (String candidate : wordDict) {
                int len = candidate.length();
                if (len <= i && !dp[i] && dp[i - len]) {
                    dp[i] = candidate.equals(s.substring(i - len, i));
                }
            }
        }
        return dp[n];
    }
}
