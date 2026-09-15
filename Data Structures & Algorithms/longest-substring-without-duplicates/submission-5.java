class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] cache = new int[256];

        int start = 0;
        int end = 0;
        int res = 0;
        while (end < s.length()) {
            char c = s.charAt(end);
            cache[c]++;

            while (cache[c] > 1) {
                cache[s.charAt(start)]--;
                start++;
            }

            res = Math.max(end - start + 1, res);
            end++;
        }

        return res;
    }
}
