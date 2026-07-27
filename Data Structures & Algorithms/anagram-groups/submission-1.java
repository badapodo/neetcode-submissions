class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> ret = new HashMap<>();

        for(String str : strs) {
            int[] alpha = new int[26];
            char[] word = str.toCharArray();
            for(int i = 0; i < str.length(); i++) {
                alpha[word[i] - 'a']++;
            }
            String wordToString = Arrays.toString(alpha);
            List<String> lst = ret.getOrDefault(wordToString, new ArrayList<>());
            lst.add(str);
            ret.put(wordToString, lst);
        }
        return new ArrayList<>(ret.values());
    }
}
