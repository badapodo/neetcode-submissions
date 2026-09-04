class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();

        int[] cache = new int[128];
        int max = 0;
        int r = 0;
        int l = 0;
        for (; r < n; r++) {
            max = Math.max(++cache[s.charAt(r)], max);

            if (r - l + 1 - max > k) {
                cache[s.charAt(l++)]--;
            }
        }

        return r - l;
    }
}
