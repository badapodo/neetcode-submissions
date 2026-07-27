class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();

        int left = 0;
        int maxf = 0;
        int ret = 0;
        for (int right = 0; right < s.length(); right++) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            maxf = Math.max(map.get(s.charAt(right)), maxf);

            while ((right - left + 1) - maxf > k) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;
            }

            ret = Math.max(ret, right - left + 1);
        }

        return ret;
    }
}
