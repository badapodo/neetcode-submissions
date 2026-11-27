class Solution {
    public bool IsPalindrome(string s) {
        List<char> lst = new List<char>();

        foreach (char c in s.ToLowerInvariant()) {
            if (c >= 'a' && c <= 'z' || c >= '0' && c <= '9')
                lst.Add(c);
        }

        int left = 0;
        int right = lst.Count - 1;

        while (left < right) {
            if (lst[left++] != lst[right--]) return false;
        }

        return true;
    }
}