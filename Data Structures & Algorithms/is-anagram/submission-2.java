class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> s1 = new HashMap<>();
        Map<Character, Integer> s2 = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            s1.put(c1, s1.getOrDefault(c1, 0) + 1);
            s2.put(c2, s2.getOrDefault(c2, 0) + 1);
        }

        return s1.equals(s2);
    }
}
