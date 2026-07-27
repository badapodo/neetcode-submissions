class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String k = new String(c);

            map.putIfAbsent(k, new ArrayList<>());
            map.get(k).add(s);
        }

        List<List<String>> ret = new ArrayList<>();
        for (String s : map.keySet()) {
            ret.add(map.get(s));
        }

        return ret;
    }
}
