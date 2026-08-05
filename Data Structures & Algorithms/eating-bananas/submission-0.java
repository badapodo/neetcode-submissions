class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int p : piles) max = Math.max(max, p);
        int l = 1;
        int r = max;
        int speed = r;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            int end = endTime(piles, mid);
            if (end <= h) {
                r = mid - 1;
                speed = mid;
                continue;
            }
            l = mid + 1;
        }
        return speed;
    }

    public int endTime(int[] piles, int time) {
        int ret = 0;
        for (int p : piles) {
            ret += (p + time - 1) / time;
        }
        return ret;
    }
}
