class Solution {
    public int characterReplacement(String s, int k) {
        char[] arr = s.toCharArray();
        int[] cache = new int[128];
        int maxChar = 0;
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            char c = arr[r];
            if (maxChar < ++cache[c]) {
                maxChar = cache[c];
            }

            if ((r - l + 1) - maxChar > k) {
                cache[arr[l++]]--;
            }
        }
        return s.length() - l;
    }
}
