class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] a = new int[26];
        int[] b = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            int curr = s1.charAt(i) - 'a';
            a[curr]++;
        }
        int l = 0;
        for (int r = 0; r < s2.length(); r++) {
            int right = s2.charAt(r) - 'a';
            b[right]++;
            if (r - l + 1 > s1.length()) {
                int left = s2.charAt(l++) - 'a';
                b[left]--;
            }
            boolean cond = true;
            for (int i = 0; i < 26; i++) {
                if (a[i] != b[i]) {
                    cond = false;
                    break;
                }
            }
            if (cond) {
                return true;
            }
        }
        return false;
    }
}
