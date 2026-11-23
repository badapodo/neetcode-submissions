class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] alph = new int[128];
        int l = 0;
        int max = 0;
        for (int r = 0; r < s.length(); r++) {
            int right = s.charAt(r);
            alph[right]++;
            
            while (alph[right] > 1) {
                int left = s.charAt(l);
                alph[left]--;
                l++;
            }
            max = Math.max(r - l + 1, max);
        }

        return max;
    }
}
