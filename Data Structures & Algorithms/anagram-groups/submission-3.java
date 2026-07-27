class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs) {
            char[] array = s.toCharArray();
            Arrays.sort(array);
            String sorted = new String(array);
            List<String> saved = map.getOrDefault(sorted, new ArrayList<>());
            saved.add(s);
            map.put(sorted, saved);
        }
        return map.values().stream().toList();
    }
}
