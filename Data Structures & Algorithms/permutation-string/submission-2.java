class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) {
            return false;
        }

        Map<Character, Integer> s1Count = new HashMap<>();
        Map<Character, Integer> s2Count = new HashMap<>();

        for(int i = 0 ; i < s1.length(); i++) {
            s1Count.put(s1.charAt(i), s1Count.getOrDefault(s1.charAt(i), 0) + 1);
            s2Count.put(s2.charAt(i), s2Count.getOrDefault(s2.charAt(i), 0) + 1);
        }

        for(int r = s1.length(); r < s2.length(); r++) {
            if (s1Count.equals(s2Count)) {
                return true;
            }
            char leftChar = s2.charAt(r - s1.length());
            s2Count.put(leftChar, s2Count.get(leftChar) - 1);
            if (s2Count.get(leftChar) == 0) {
                s2Count.remove(leftChar); 
            }

            char rightChar = s2.charAt(r);
            s2Count.put(rightChar, s2Count.getOrDefault(rightChar, 0) + 1);
        }
        
        return s1Count.equals(s2Count);
    }
}
