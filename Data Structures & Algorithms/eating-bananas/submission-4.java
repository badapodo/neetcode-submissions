class Solution {
    int[] piles;
    int h;
    public int minEatingSpeed(int[] piles, int h) {
        this.piles = piles;
        this.h = h;
        int r = 1_000_000_000;
        int l = 1;
        int res = r;
        while (l <= r) {
            int mid = (r + l) >>> 1;
            if (validate(mid)) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }

    private boolean validate(int mid) {
        long cnt = 0;
        for (int i = 0; i < piles.length; i++) {
            cnt += (piles[i] + (mid - 1)) / mid;
        }
        return cnt <= h;
    }
}
