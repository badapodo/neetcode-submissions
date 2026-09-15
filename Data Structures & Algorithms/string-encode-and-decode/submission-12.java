class Solution {
    char sep = '#';
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()).append(sep).append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        char[] arr = str.toCharArray();

        int pointer = 0;
        int numberStart = 0;
        while (pointer < str.length()) {
            char curr = arr[pointer];
            if (curr == sep) {
                int length = Integer.parseInt(str.substring(numberStart, pointer));
                if (length == 0) {
                    res.add("");
                }
                else res.add(str.substring(pointer + 1, pointer + 1 + length));

                pointer += length + 1;
                numberStart = pointer;
                continue;
            }
            pointer++;
        }

        return res;
    }
}
