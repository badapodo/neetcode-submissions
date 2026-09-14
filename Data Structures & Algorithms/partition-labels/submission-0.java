class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> start = new HashMap<>();
        Map<Character, Integer> end = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            if (!start.containsKey(curr)) {
                start.put(curr, i);
            }
            end.put(curr, i);
        }
        int[] arr = new int[s.length()];
        for (int i : start.values()) {
            arr[i]++;
        }

        for (int i : end.values()) {
            arr[i]--;
        }
        int prev = 0;
        int curr = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            curr += arr[i];
            if (curr == 0) {
                res.add(i - prev + 1);
                prev = i + 1;
            }
        }

        return res;
    }
}
