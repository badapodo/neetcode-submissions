class Solution {
    public boolean isAnagram(String s, String t) {
        int[] set = new int[26];
        for (char c : s.toCharArray()) {
            set[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            set[c - 'a']--;
        }

        for (int i : set) {
            if (i != 0) return false;
        }
        return true;
    }
}
