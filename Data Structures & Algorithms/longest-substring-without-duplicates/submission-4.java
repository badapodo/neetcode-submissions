class Solution {
    public int lengthOfLongestSubstring(String s) {
        boolean[] cache = new boolean[128];
        int l = 0;
        int ret = 0;
        char[] arr = s.toCharArray();
        for (int r = 0; r < s.length(); r++) {
            while (cache[arr[r]]) {
                cache[arr[l++]] = false;
            }
            cache[arr[r]] = true;
            ret = Math.max(ret, r - l + 1);
        }
        return ret;
    }
}
