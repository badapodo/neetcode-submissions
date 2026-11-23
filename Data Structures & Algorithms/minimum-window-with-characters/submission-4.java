class Solution {
    public String minWindow(String s, String t) {
        int min = Integer.MAX_VALUE;
        StringBuilder sb = new StringBuilder();

        int[] a = new int[128];
        int[] b = new int[128];

        for (int i = 0; i < t.length(); i++) {
            b[t.charAt(i)]++;
        }

        int l = 0;
        String res = "";
        for (int r = 0; r < s.length(); r++) {
            int right = s.charAt(r);
            sb.append((char)right);
            a[right]++;

            while (validate(a, b)) {
                if (r - l + 1 < min) {
                    res = sb.toString();
                    min = r - l + 1;
                }

                int left = s.charAt(l++);
                a[left]--;
                sb.deleteCharAt(0);
            }
        }
        return res;
    }

    private boolean validate(int[] a, int[] b) {
        for (int i = 0; i < 128; i++) {
            if (a[i] < b[i]) {
                return false;
            }
        }
        return true;
    }
}
