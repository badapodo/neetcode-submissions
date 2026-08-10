class Solution {
    public String minWindow(String s, String t) {
        int[] ans = new int[128];
        int[] curr = new int[128];
        char[] sArr = s.toCharArray();

        for (char c : t.toCharArray()) {
            ans[c]++;
        }

        int l = 0;
        int resL = 0;
        int resR = 0;
        boolean find = false;
        for (int r = 0; r < s.length(); r++) {
            if (r - l + 1 < t.length()) {
                curr[sArr[r]]++;
                continue;
            }
            curr[sArr[r]]++;
            // System.out.print("this: " + sArr[r] + "\n");
            if (validResult(ans, curr)) {
                // System.out.print("this: " + sArr[r] + "\n");
                while (validResult(ans, curr)) {
                curr[sArr[l++]]--;
                }
                curr[sArr[--l]]++;

                if (!find || (resR - resL > r - l)) {
                    resR = r;
                    resL = l;
                }
                find = true;
            }
        }
        StringBuilder sb = new StringBuilder();
        if (!find) return "";
        for (int i = resL; i <= resR; i++) {
            sb.append(sArr[i]);
        }
        return sb.toString();
    }

    private boolean validResult(int[] ans, int[] curr) {
        for (int i = 0; i < 128; i++) {
            if (ans[i] > 0 && ans[i] > curr[i]) return false;
        }
        return true;
    }
}
