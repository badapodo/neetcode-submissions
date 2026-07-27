class Solution {
    public List<String> generateParenthesis(int n) {
        List<List<String>> dp = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            dp.add(new ArrayList<>());
        }
        dp.get(0).add("");

        for (int k = 0; k <= n; k++) {
            for (int i = 0; i < k; i++) {
                for (String left : dp.get(i)) {
                    for (String right : dp.get(k - i - 1)) {
                        dp.get(k).add("(" + left + ")" + right);
                    }
                }
            }
        }
        return dp.get(n);
    }
}
