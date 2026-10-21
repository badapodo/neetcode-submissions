class Solution {
    public int lastStoneWeightII(int[] stones) {
        Set<Integer> curr = new HashSet<>();
        curr.add(-stones[0]);
        curr.add(stones[0]);
        for (int i = 1; i < stones.length; i++) {
            int num = stones[i];
            Set<Integer> next = new HashSet<>();
            for (int j : curr) {
                next.add(j - num);
                next.add(j + num);
            }
            curr = next;
        }

        int res = Integer.MAX_VALUE;
        // System.out.print(curr);
        for (int i : curr) {
            res = Math.min(Math.abs(i), res);
        }

        return res;
    }
}