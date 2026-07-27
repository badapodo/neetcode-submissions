class Solution {
    public int[] plusOne(int[] digits) {
        boolean carry = true;

        for (int j = digits.length - 1; j >= 0; j--) {
            if (carry) {
                if (digits[j] == 9) {
                    digits[j] = 0;
                } else {
                    digits[j]++;
                    carry = false;
                }
            }
        }

        if (carry) {
            int[] ret = new int[digits.length + 1];
            ret[0] = 1;
            System.arraycopy(digits, 0, ret, 1, digits.length);
            return ret;
        }
        return digits;
    }
}
