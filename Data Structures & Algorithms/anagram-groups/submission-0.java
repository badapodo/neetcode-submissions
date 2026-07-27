class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> table = new HashMap<>();

        for(int i = 0; i < strs.length; i++) {
            char[] charArr = strs[i].toCharArray();
            Arrays.sort(charArr);
            List<String> values = table.getOrDefault(String.valueOf(charArr), new ArrayList<>());
            values.add(strs[i]);
            table.put(String.valueOf(charArr), values);
        }

        return table.values()
                .stream().toList();
    }
}