class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1Cache = new int[26];
        int[] s2Cache = new int[26];
        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();
        int n = s1.length();
        int l = 0;

        for (char c : s1Arr) {
            s1Cache[toInt(c)]++;
        }

        for (int r = 0; r < s2.length(); r++) {
            if (r - l + 1 < n) {
                s2Cache[toInt(s2Arr[r])]++;
                continue;
            }
            s2Cache[toInt(s2Arr[r])]++;
            if (isPermutation(s1Cache, s2Cache)) return true;
            s2Cache[toInt(s2Arr[l])]--;
            l++;
        }
        return false;
    }

    private int toInt(char c) {
        return c - 'a';
    }

    private boolean isPermutation(int[] s1C, int[] s2C) {
        for (int i = 0; i < 26; i++) {
            if (s1C[i] != s2C[i]) return false;
        }
        return true;
    }
}
