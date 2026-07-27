class Solution {

    public String encode(List<String> strs) {
       StringBuilder sb = new StringBuilder();
       for(String str : strs) {
        sb.append(str.length()).append("#").append(str);
       }
       return sb.toString();
    }

    public List<String> decode(String str) {
        int index = 0;
        List<String> ret = new ArrayList<>();
        while(index != str.length()) {
            int sparse = str.indexOf("#", index);
            int size = Integer.parseInt(str.substring(index, sparse));
            ret.add(str.substring(sparse + 1, sparse + 1 + size));
            index = sparse + 1 + size;
        }
        return ret;
    }
}
