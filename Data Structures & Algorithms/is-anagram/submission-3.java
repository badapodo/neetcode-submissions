class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        
        int[] alphA = new int[26];
        int[] alphB = new int[26];
        for(int i = 0; i < 26; i++) {
            alphA[i] = 0;
            alphB[i] = 0;
        }
        for(char c : s.toCharArray()) {
            alphA[toInteger(c)]++;
        }
        for(char c : t.toCharArray()) {
            alphB[toInteger(c)]++;
        }

        for(int i = 0; i < 26; i++) {
            if(alphA[i] != alphB[i]) {
                return false;
            }
        }

        return true;
    }

    public int toInteger(char c) {
        return c - 'a';
    }
}
