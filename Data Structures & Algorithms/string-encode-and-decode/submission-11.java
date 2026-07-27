class Solution {
    char code = '\0';

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s).append(code);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> ret = new ArrayList<>();
        StringBuilder sb = new StringBuilder("");
        for (char s : str.toCharArray()) {
            if (s == code) {
                ret.add(sb.toString());
                sb = new StringBuilder("");
                continue;
            }
            sb.append(s);
        }
        return ret;
    }
}
