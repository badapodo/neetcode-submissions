class Solution {
    public boolean isPalindrome(String s) {
        List<Character> lst = new ArrayList<>();

        for (char c : s.toLowerCase().toCharArray()) {
            if (c >= 'a' && c <= 'z' || c >= '0' && c <= '9') lst.add(c);
        }

        int left = 0; int right = lst.size() - 1;
        while (left < right) {
            // System.out.printf("left: %c    right: %c \n", lst.get(left), lst.get(right));
            if (!lst.get(left++).equals(lst.get(right--))) return false;
        }
        return true;
    }
}
